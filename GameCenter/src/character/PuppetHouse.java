package character;

import card.Card;

import java.util.ArrayList;

public class PuppetHouse extends Character {

    public PuppetHouse() {
        super(15);
    }

    @Override
    public String getName() {
        return "卡夫卡";
    }

    @Override
    int[] getDeckCardsCount() {
        return new int[]{7, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0, 3};
    }
}
