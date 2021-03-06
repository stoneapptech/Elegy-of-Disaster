package gameCenter;

import EODObject.Cards;
import card.Card;
import card.active.ActiveCard;
import card.active.Grenade;
import card.aggressive.AggressiveCard;
import card.passive.PassiveCard;
import client.Client;
import exceptions.ChooseZeroException;
import exceptions.NoOneLostException;
import pipe.Pipe;
import pipe.Pipes;
import propperty.Property;

import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.HashMap;

public abstract class GameCenter {

    public static String gameStarted = "GameStarted";
    public static String lose = "loser: %s";

    abstract int getPipesCount();
    abstract boolean gameShouldEnd();
    abstract Pipe getLost() throws NoOneLostException;

    //an array representing pipes
    protected Pipes pipes = new Pipes();
    //an hash map representing each players hands
    //key: pipe
    //value: hands
    private HashMap<Pipe, Cards> hands;
    //use this map to record the order of players
    //the value is the next player after the key
    private HashMap<Pipe, Pipe> players = new HashMap<>();
    private HashMap<Pipe, Boolean> canDefense = new HashMap<>();
    private HashMap<Pipe, Boolean> canAttack = new HashMap<>();
    //use null to represent that the pipe has not properties
    private HashMap<Pipe, Property> properties = new HashMap<>();
    public Property getPropertyOf(Pipe pipe) {
        return properties.get(pipe);
    }

    public void begin(Client... clients) {
        setup(clients);
        pipes.broadcast(gameStarted);
        loop();
    }

    private void setup(Client... clients) {
        for(int i = 0; i < getPipesCount(); i++) {
            Pipe p = new Pipe(this, clients[i]);
            pipes.add(p);
            clients[i].pipe = p;
        }
        hands = new HashMap<>();
        for (int i = 0; i < getPipesCount(); i++) {
            Cards deck = pipes.get(i).getCharacter().getDeck();
            Cards hand = new Cards();
            Cards cards = drawCard(deck, 3);
            for(int j = 0; j < 3; j++) {
                Card c = cards.get(j);
                deck.remove(c);
                hand.add(c);
                pipes.get(i).receivedCard(c);
            }
            hands.put(pipes.get(i), hand);
        }

        for(int i = 0; i < getPipesCount(); i++) {
            players.put(pipes.get(i), pipes.get( (i+1)%getPipesCount() ));
        }
        for(Pipe p:pipes) {
            canDefense.put(p, true);
            canAttack.put(p, true);
            properties.put(p, null);
        }
    }

    public boolean changeDefensible(Pipe pipe, boolean status) {
        canDefense.put(pipe, status);
        return status;
    }
    
    public boolean changeAttackable(Pipe pipe, boolean status) {
        canAttack.put(pipe, status);
        return status;
    }
    
    private Pipe current = null;
    private void loop() {
        while(true) {
            if(gameShouldEnd()) {
                try {
                    pipes.broadcast(String.format(GameCenter.lose, getLost().toString()));
                    break;
                } catch (NoOneLostException e) {
                    //don't need to do anything since it's checked the someone has lost
                }
            }
            current = nextPlayer(current);
            current.startNextTurn();

            Card card = drawCard(current.getCharacter().getDeck());

            current.receivedCard(card);
            current.getCharacter().getDeck().remove(card);
            hands.get(current).add(card);

            current.displayLife();
            current.send("請出牌:(或輸入0放棄)");
            if (!canDefense.get(current)){
                canDefense.put(current, true);
            }
            while(current.getAvailableCost() > 0) {
                current.send("剩餘cost:" + current.getAvailableCost());
                try {
                    current.requirePlayCard(hands.get(current));
                } catch (ChooseZeroException e) {
                    current.activateBuffer(current, players, this);
                    properties.forEach((pipe, property) -> {
                        if(property != null && property.shouldDisappear()) {
                            properties.put(pipe, null);
                        }
                    });
                    break;
                }
                if (!canAttack.get(current)){
                    canAttack.put(current, true);
                }
            }
            //turn ends
            Cards currentHand = hands.get(current);
            int grenadeCount = currentHand.contains(Grenade.class);
            current.decreaseLife(4 * grenadeCount);
            currentHand.removeAll(Grenade.class);
        }
    }

    public void onClientPlayCard(int number) {
        Card card = hands.get(current).get(number-1);
        if(card instanceof ActiveCard) {
            current.appendCardToBuffer(card);
        }
        if(card instanceof AggressiveCard) {
            Pipe opponent = players.get(current);
            Cards passive = hands.get(opponent).filter(c -> c instanceof PassiveCard);
            if(passive.isNotEmpty() && canDefense.get(opponent)) {
                opponent.askDefend(passive);
            }
        }
        boolean successAttacked = current.activateBuffer(current, players, this);
        if(successAttacked) {
            current.onAttackSuccessfully(players);
        }
        hands.get(current).remove(number-1);
    }

    public void onClientPlayDefensive(int number) {
        Pipe opponent = players.get(current);
        Cards passive = hands.get(opponent).filter(c -> c instanceof PassiveCard);
        Card chosen = passive.get(number-1);
        current.insertCardToBufferHead(chosen);
        hands.get(opponent).remove(chosen);
//        opponent.getCharacter().onDefendSuccessfully();

    }
    
    public void onAskedToDrawCard(int number) {
        Cards c = drawCard(current.getCharacter().getDeck(), number);
        hands.get(current).add(c);
        for(Card card: c) {
            current.getCharacter().getDeck().remove(card);
        }
        current.receivedCards(c);
    }

    //broadcast methods for pipe
    public void characterHealed(int life, Pipe healed) {
        for(Pipe p: pipes) {
            if(p != healed) {
                p.send(healed.client.getCharacter().getName() + "回復了" + life + "點生命值");
            }
        }
    }
    public void broadcast(String message) {
        pipes.broadcast(message);
    }
    private Pipe nextPlayer(Pipe current) {
        return players.getOrDefault(current, pipes.get(0));
    }

    public Card loseCardOn(Pipe pipe) {
        Cards cards = hands.get(pipe);
        Card lost = cards.removeRandomly();
        pipe.onLoseCard(lost);
        return lost;
    }
    //These are not destructive
    //Please remove the cards from deck and add cards to hand manually
    private Card drawCard(Cards fromCards) {
        return drawCard(fromCards, 1).get(0);
    }
    private Cards drawCard(Cards fromCards, int num) {
        Cards cards = new Cards();
        for(int j = 0; j < num; j++) {
            Card card = fromCards.get(j);
            cards.add(card);
        }
        return cards;
    }

    public void addToHand(Card c, Pipe pipe) {
        hands.get(pipe).add(c);
    }

    public boolean getCanAttack(Pipe pipe) {
        return canAttack.get(pipe);
    }

    public HashMap<Pipe, Cards> sendHands(){
        return hands;
    }

    public Cards lookRandomCard(Pipe pipe, int num) {
        Cards hand = hands.get(pipe);
        Cards looked = new Cards();
        ArrayList<Integer> ints = new ArrayList<>();
        new Random().ints(hand.size(), 0, hand.size()).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                if(!ints.contains(value) && ints.size()<num) {
                    ints.add(value);
                    looked.add(hand.get(value));
                }
            }
        });
        return looked;
    }
    public void placeProperty(Pipe pipe, Property property) {
        properties.put(pipe, property);
    }
}
