package character;

import card.Card;

import java.util.ArrayList;

public class FrozenHeart extends Character {

    public FrozenHeart() {
        super(18);
    }

    @Override
    public String getName() {
        return "雪村";
    }

    @Override
    int[] getDeckCardsCount() {
        return new int[]{6, 6, 7, 3, 7, 3, 2, 2, 0, 5, 0, 0, 2};
    }
}
