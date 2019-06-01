package effect;

import pipe.Pipe;

public class LookOpponentCard extends Effect{

    private Pipe opponent;

    public LookOpponentCard(Pipe opponent){this.opponent = opponent;}

    @Override

    public boolean invoke() {
        return true;
    }
}