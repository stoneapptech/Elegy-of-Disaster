package effect;

import pipe.Pipe;

public class GetSpecial extends Effect {

    private Pipe owner;

    public GetSpecial(Pipe owner) {
        this.owner = owner;
    }

    @Override
    public void invoke() {
        owner.getSpecialFromDeck();
    }
}
