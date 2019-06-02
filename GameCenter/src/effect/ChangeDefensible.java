package effect;

import pipe.Pipe;

public class ChangeDefensible extends Effect{

    private Pipe opponent;
    private boolean status;

    public ChangeDefensible(Pipe opponent, boolean status) {
        this.opponent = opponent;
        this.status = status;
    }


    @Override
    public boolean invoke() {
        this.opponent.changeDefensible(this.status);
        return true;
    }
}
