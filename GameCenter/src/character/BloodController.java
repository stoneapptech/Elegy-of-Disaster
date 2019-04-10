package character;

import card.Attack;
import card.Card;

import java.util.ArrayList;

public class BloodController extends Character {
    @Override
    String getName() {
        return "梅";
    }

    @Override
    int getLife() {
        return 15;
    }

    @Override
    int[] getDeckCardsCount() {
        return new int[]{7, 5, 5, 5, 5, 5, 3, 3, 1, 1, 1, 1, 1};
    }
}
