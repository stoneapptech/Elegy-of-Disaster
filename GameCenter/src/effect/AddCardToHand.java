package effect;

import card.Card;
import pipe.Pipe;

public class AddCardToHand extends Effect {

    private Card card;
    private Pipe subject;
    public AddCardToHand(Card c, Pipe subject) {
        this.card = c;
        this.subject = subject;
    }

    @Override
    public boolean invoke() {
        subject.addCardToHand(card);
        return true;
    }
}
