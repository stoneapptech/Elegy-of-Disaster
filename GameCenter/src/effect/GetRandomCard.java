package effect;

import card.Card;
import pipe.Pipe;

public class GetRandomCard extends Effect {

    private Pipe receiver;
    private Pipe giver;

    public GetRandomCard(Pipe receiver, Pipe giver) {
        this.receiver = receiver;
        this.giver = giver;
    }

    @Override
    public void invoke() {
        Card lost = giver.loseRandomCard();
        receiver.receivedCard(lost);
    }
}
