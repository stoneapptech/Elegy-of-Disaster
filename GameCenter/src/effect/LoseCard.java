package effect;

import pipe.Pipe;

public class LoseCard extends Effect {

    private Pipe opponent;
    private int num;
    public LoseCard(int num, Pipe opponent) {
        this.num = num;
        this.opponent = opponent;
    }


    @Override
    public boolean invoke() {
        opponent.loseRandomCard();
        return true;
    }
}