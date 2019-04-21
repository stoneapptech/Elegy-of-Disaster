package character;

import card.Card;

import java.util.ArrayList;

public class Transcender extends Character {
    @Override
    public String getName() {
        return "小兔";
    }

    @Override
    public int getLife() {
        return 12;
    }

    @Override
    int[] getDeckCardsCount() {
        return new int[]{10, 2, 3, 3, 5, 9, 4, 2, 0, 0, 0, 3, 0};
    }
}
