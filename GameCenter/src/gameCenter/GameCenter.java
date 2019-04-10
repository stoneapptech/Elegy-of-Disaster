package gameCenter;

import card.Card;
import client.Client;
import pipe.Pipe;

import java.util.ArrayList;

public abstract class GameCenter {
    //an array representing pipes
    private ArrayList<Pipe> pipes;
    abstract int getPipesCount();
    //an array representing each players hands
    private ArrayList<Card>[] hands;

    GameCenter() {
        for(int i = 0; i < getPipesCount(); i++) {
            pipes.add(new Pipe(this));
        }
        hands = new ArrayList[getPipesCount()];
    }

    GameCenter(Client... clients) {
        this();
        for (int i = 0; i < getPipesCount(); i++) {
            pipes.get(i).setClient(clients[i]);
            ArrayList<Card> deck = pipes.get(i).getCharacter().getDeck();
            ArrayList<Card> hand = new ArrayList<>(3);
            for(int i = 0; i < 3; i++) {
                hand.add(deck.remove(0));
            }
            hands[i] = deck.remove()
        }
    }


}
