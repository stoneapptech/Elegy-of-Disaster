package character;

import card.Card;

import java.util.ArrayList;

public class DoubleReturn extends Character {
    @Override
    String getName() {
        return "正作";
    }

    @Override
    int getLife() {
        return 15;
    }

    @Override
    int[] getDeckCardsCount() {
        return new int[] {7, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0, 3};
    }
}
