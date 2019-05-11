package gameCenter;

import card.Card;
import card.active.ActiveCard;
import card.aggressive.AggressiveCard;
import card.passive.Dodge;
import card.passive.PassiveCard;
import client.Client;
import exceptions.ChooseZeroException;
import exceptions.NoOneLostException;

import pipe.Pipe;
import pipe.Pipes;

import EODObject.Cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;

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
            while(current.getAvailableCost() != 0) {
                current.send("剩餘cost:" + current.getAvailableCost());
                try {
                    current.requirePlayCard(hands.get(current));
                } catch (ChooseZeroException e) {
                    //user choose zero
                    break;
                }
            }
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
            opponent.askDefend(passive);
        }
        current.activateBuffer(current, players, this);
    }

    public void onClientPlayDefensive(int number) {
        Pipe opponent = players.get(current);
        Cards passive = hands.get(opponent).filter(c -> c instanceof PassiveCard);
        Card chosen = passive.get(number-1);
        current.insertCardToBufferHead(chosen);
        current.activateBuffer(current, players, this);
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
    private Pipe nextPlayer(Pipe current) {
        return players.getOrDefault(current, pipes.get(0));
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

}
