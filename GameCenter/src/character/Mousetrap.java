package character;

import card.Card;

import java.util.ArrayList;

public class Mousetrap extends Character {
    @Override
    String getName() {
        return "W";
    }

    @Override
    int getLife() {
        return 12;
    }

    @Override
    int[] getDeckCardsCount() {
        return new int[]{6, 6, 6, 0, 7, 7, 4, 4, 0, 0, 3, 0, 0};
    }
}
