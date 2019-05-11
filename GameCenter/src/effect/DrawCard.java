package effect;

import EODObject.Cards;
import card.Card;
import pipe.Pipe;


public class DrawCard extends Effect {
    private Pipe subject;
    private int num;
    public DrawCard(int num, Pipe subject) {
        this.subject = subject;
        this.num = num;
    }

    @Override
    public void invoke() {
        subject.drawCard(num);
    }
}
