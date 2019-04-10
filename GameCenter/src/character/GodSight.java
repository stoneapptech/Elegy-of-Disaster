package character;

import card.Card;

import java.util.ArrayList;

public class GodSight extends Character {
    @Override
    String getName() {
        return "安";
    }

    @Override
    int getLife() {
        return 15;
    }

    @Override
    int[] getDeckCardsCount() {
        return new int[]{7, 5, 5, 5, 3, 7, 2, 2, 5, 1, 0, 0, 1};
    }
}
