package character;

import card.Card;

import java.util.ArrayList;

public class FrozenHeart extends Character {
    @Override
    public String getName() {
        return "雪村";
    }

    @Override
    public int getLife() {
        return 18;
    }

    @Override
    int[] getDeckCardsCount() {
        return new int[]{6, 6, 7, 3, 7, 3, 2, 2, 0, 5, 0, 0, 2};
    }
}
