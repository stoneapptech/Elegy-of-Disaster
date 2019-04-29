package character;

import card.Card;

import java.util.ArrayList;

public class FlamedHeart extends Character {

    public FlamedHeart() {
        super(12);
    }
    @Override
    public String getName() {
        return "海爾";
    }

    @Override
    int[] getDeckCardsCount() {
        return new int[]{10, 2, 3, 3, 7, 7, 0, 0, 3, 0, 0, 4, 0};
    }
}
