package effect;

import pipe.Pipe;

public class InvalidateAggressive extends Effect {

    private Pipe subject;
    public InvalidateAggressive(Pipe current) {
        subject = current;
    }

    @Override
    public void invoke() {
        subject.invalidateAggressive();
    }
}
