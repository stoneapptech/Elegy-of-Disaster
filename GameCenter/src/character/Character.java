package character;

import card.Card;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class Character {
    public abstract String getName();
    public abstract int getLife();
    abstract int[] getDeckCardsCount();

    private ArrayList<Card> deck = null;
    public ArrayList<Card> getDeck() {
        if(deck == null) {
            ArrayList<Card> initialDeck = new ArrayList<Card>() {{
                String[] cards = {"Attack",
                        "Defense",
                        "Cure",
                        "Supply",
                        "TakeOver",
                        "QuickAttack",
                        "Dodge",
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
