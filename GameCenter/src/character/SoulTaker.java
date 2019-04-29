package character;

import card.Card;

import java.util.ArrayList;

public class SoulTaker extends Character {

    public SoulTaker() {
        super(10);
    }

    @Override
    public String getName() {
        return "桑德";
    }

    @Override
    int[] getDeckCardsCount() {
        return new int[]{5, 3, 3, 3, 3, 3, 2, 2, 0, 0, 2, 2, 2};
    }
}
