package EODObject;

import card.Card;
import com.sun.istack.internal.NotNull;

import java.util.*;
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
    public void add(int index, Card c) {
        cardArray.add(index, c);
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
    public boolean removeIf(Predicate<? super Card> predicate) {
        return cardArray.removeIf(predicate);
    }
    public Card removeRandomly() {
        int index = new Random().nextInt(cardArray.size());
        return cardArray.remove(index);
    }
    public void clear() {
        cardArray.clear();
    }

    public boolean isEmpty() {
        return cardArray.isEmpty();
    }
    public boolean isNotEmpty() {
        return !cardArray.isEmpty();
    }


    //support foreach
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
