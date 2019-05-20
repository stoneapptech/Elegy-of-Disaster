package EODObject;

import card.Card;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Cards implements Iterable<Card> {
    private ArrayList<Card> cardArray;

    public Cards() {
        cardArray = new ArrayList<>();
    }
    public Cards(ArrayList<Card> cards) {
        cardArray = cards;
    }

    public void add(Card c) {
        cardArray.add(c);
    }
    public void add(Cards cards) {
        for(Card c: cards) {
            add(c);
        }
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
    public boolean remove(Card card) {
        return cardArray.remove(card);
    }
    public Card remove(int index) {
        return cardArray.remove(index);
    }
    public Card removeRandomly() {
        int index = new Random().nextInt(cardArray.size());
        return cardArray.remove(index);
    }


    //support foreach
    @NotNull
    @Override
    public Iterator<Card> iterator() {
        return cardArray.iterator();
    }

    @Override
    public void forEach(Consumer<? super Card> action) {
        cardArray.forEach(action);
    }

    @Override
    public Spliterator<Card> spliterator() {
        return cardArray.spliterator();
    }
}
