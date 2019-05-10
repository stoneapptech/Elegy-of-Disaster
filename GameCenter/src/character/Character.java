package character;

import card.Card;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class Character {

    protected int life;
    protected Character(int life) {
        this.life = life;
    }
    public abstract String getName();
    public int getLife() {
        return life;
    }
    abstract int[] getDeckCardsCount();
    public void increaseLife() {
        increaseLifeBy(1);
    }
    public void increaseLifeBy(int num) {
        life += num;
    }
    public void decreaseLife() {
        decreaseLifeBy(1);
    }
    public void decreaseLifeBy(int num) {
        life -= num;
    }

    private ArrayList<Card> deck = null;
    public ArrayList<Card> getDeck() {
        if(deck == null) {
            ArrayList<Card> initialDeck = new ArrayList<Card>() {{
                String[] cards = {"aggressive.Attack",
                        "Cure",
                        "Supply",
                        "TakeOver",
                        "QuickAttack",
                        "passive.Dodge",
                        "Strategy",
                        "SpreadAttack",
                        "Bless",
                        "Poison",
                        "Mad",
                        "Counter"};
                for (int i = 0; i < getDeckCardsCount().length; i++) {
                    for (int j = 0; j < getDeckCardsCount()[i]; j++) {
                        try {
                            add((Card) Class.forName("card." + cards[i]).newInstance());
                        } catch (Exception e) {
                            //don't have to do anything
                            //this won't happen
                        }
                    }
                }
            }};
            Collections.shuffle(initialDeck);
            deck = initialDeck;
        }
        return deck;
    }
}
