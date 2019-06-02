package effect;

import pipe.Pipe;

public class InvalidateAggressive extends Effect {

    private Pipe subject;
    public InvalidateAggressive(Pipe current) {
        subject = current;
    }

    @Override
    public boolean invoke() {
        subject.invalidateAggressive();
        return true;
    }
}
