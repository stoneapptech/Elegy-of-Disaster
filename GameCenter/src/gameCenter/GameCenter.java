package gameCenter;

import card.Card;
import client.Client;
import exceptions.NoOneLostException;

import pipe.Pipe;
import pipe.Pipes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public abstract class GameCenter {

    public static String gameStarted = "GameStarted";
    public static String lose = "loser: %s";

    abstract int getPipesCount();
    abstract int getCost();

    //an array representing pipes
    private Pipes pipes = new Pipes();
    //an array representing each players hands
    private ArrayList<Card>[] hands;
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
        hands = new ArrayList[getPipesCount()];
        for (int i = 0; i < getPipesCount(); i++) {
            ArrayList<Card> deck = pipes.get(i).getCharacter().getDeck();
            ArrayList<Card> hand = new ArrayList<>(3);
            ArrayList<Card> cards = drawCard(deck, 3);
            for(int j = 0; j < 3; j++) {
                Card c = cards.get(j);
                deck.remove(c);
                hand.add(c);
                pipes.get(i).receivedCard(c);
            }
            hands[i] = hand;
        }

        for(int i = 0; i < getPipesCount(); i++) {
            players.put(pipes.get(i), pipes.get( (i+1)%getPipesCount() ));
        }
    }

    private Pipe current = null;
    private void loop() {
        while(true) {
            if(isSomeoneLost()) {
                try {
                    pipes.broadcast(String.format(GameCenter.lose, getLost().toString()));
                    break;
                } catch (NoOneLostException e) {
                    //don't need to do anything since it's checked the someone has lost
                }
            }
            current = nextPlayer(current);
            current.startNextTurn();

            int playerIndex = pipes.indexOf(current);
            Card card = drawCard(current.getCharacter().getDeck());

            current.receivedCard(card);
            current.getCharacter().getDeck().remove(card);
            hands[playerIndex].add(card);

            current.displayLife();
            current.send("請出牌:(或輸入0放棄)");
            current.requirePlayCard(hands[playerIndex]);
        }
    }

    public void onClientPlayCard(int number) {

    }

    private boolean isSomeoneLost() {
        return IntStream.of(pipes.askingForLifes()).anyMatch(x -> x < 0);
    }
    //get the lost one
    private Pipe getLost() throws NoOneLostException {
        try {
            int lose = IntStream.of(pipes.askingForLifes()).filter(x -> x < 0).toArray()[0];
            return pipes.get(lose);
        } catch (IndexOutOfBoundsException e) {
            throw new NoOneLostException();
        }


    }
    private Pipe nextPlayer(Pipe current) {
        return players.getOrDefault(current, pipes.get(0));
    }

    //These are not destructive
    //Please remove the cards from deck and add cards to hand manually
    private Card drawCard(ArrayList<Card> fromCards) {
        return drawCard(fromCards, 1).get(0);
    }
    private ArrayList<Card> drawCard(ArrayList<Card> fromCards, int num) {
        ArrayList<Card> cards = new ArrayList<>(num);
        for(int j = 0; j < num; j++) {
            Card card = fromCards.get(j);
            cards.add(card);
        }
        return cards;
    }

}
