package effect;

import pipe.Pipe;

public class ChangeAttackable extends Effect{

    private Pipe opponent;
    private boolean status;

    public ChangeAttackable(Pipe opponent, boolean status){
        this.opponent = opponent;
        this.status = status;
    }

    @Override
    public boolean invoke() {
        this.opponent.changeAttackable(this.status);
        return true;
    }
}
