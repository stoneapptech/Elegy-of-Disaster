package character;

import card.Card;

import java.util.ArrayList;

public class Spacezipper extends Character {

    public Spacezipper() {
        super(15);
    }

    @Override
    public String getName() {
        return "圭月";
    }

    @Override
    int[] getDeckCardsCount() {
        return new int[]{7, 5, 5, 5, 5, 5, 3, 3, 1, 1, 1, 1, 1};
    }
}
