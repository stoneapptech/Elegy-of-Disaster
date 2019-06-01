package effect;

import pipe.Pipe;

public class RemoveNegative extends Effect {
    Pipe subject;
    public RemoveNegative(Pipe subject) {
        this.subject = subject;
    }
    @Override
    public boolean invoke() {
        subject.setPoisoned(0);
        return true;
    }
}
