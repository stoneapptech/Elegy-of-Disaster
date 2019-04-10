package character;

import card.Card;

import java.util.ArrayList;

public class AtmosphereMaster extends Character {
    @Override
    String getName() {
        return "銀";
    }

    @Override
    int getLife() {
        return 15;
    }

    @Override
    ArrayList<Card> getInitialDeck() {
        return null;
    }
}
