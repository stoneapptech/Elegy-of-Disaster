package character;

import card.Card;

import java.util.ArrayList;

public class Transcender extends Character {

    public Transcender() {
        super(12);
    }

    @Override
    public String getName() {
        return "小兔";
    }

    @Override
    int[] getDeckCardsCount() {
//        return new int[]{10, 2, 3, 3, 5, 9, 4, 2, 0, 0, 0, 3, 0};
        return new int[]{0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0};
    }
}
