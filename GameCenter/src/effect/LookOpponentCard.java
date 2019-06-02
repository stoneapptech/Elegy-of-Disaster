package effect;

import EODObject.Cards;
import card.Card;
import pipe.Pipe;

public class LookOpponentCard extends Effect{

    private Pipe opponent, subject;
    private Cards opponentHand;

    public LookOpponentCard(Pipe subject, Pipe opponent, int num){
        this.opponent = opponent;
        this.subject = subject;
        this.opponentHand = opponent.lookRandomHand(num);
    }

    @Override

    public boolean invoke() {
        for (Card c: opponentHand) {
            subject.send(subject.getCharacter().getName() + "截獲了" + c.getName() + "的情報");
        }
        return true;
    }
}