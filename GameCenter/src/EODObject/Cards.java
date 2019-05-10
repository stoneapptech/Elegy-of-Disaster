package EODObject;

import card.Card;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Cards {
    private ArrayList<Card> cardArray;

    public Cards(ArrayList<Card> cards) {
        cardArray = cards;
    }

    public void add(Card c) {
        cardArray.add(c);
    }

    public Card get(int index) {
        return cardArray.get(index);
    }

    public int size() {
        return cardArray.size();
    }

    public Cards filter(Predicate<? super Card> predicate) {
        ArrayList<Card> passedCards = new ArrayList<>();
        for(Card c: cardArray) {
            if(predicate.test(c)) {
                passedCards.add(c);
            }
        }
        return new Cards(passedCards);
    }
}
