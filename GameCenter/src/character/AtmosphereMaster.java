package character;

import card.Card;

import java.util.ArrayList;

public class AtmosphereMaster extends Character {
    @Override
    public String getName() {
        return "銀";
    }

    @Override
    public int getLife() {
        return 15;
    }

    @Override
    int[] getDeckCardsCount() {
        return new int[]{5, 3, 5, 5, 7, 5, 3, 5, 0, 2, 0, 0, 2};
    }
}
