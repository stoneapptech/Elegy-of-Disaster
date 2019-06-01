package effect;

import pipe.Pipe;

public class Poisoning extends Effect {
    private int point;
    private Pipe subject;
    public Poisoning(int point, Pipe subject) {
        this.point = point;
        this.subject = subject;
    }

    @Override
    public boolean invoke() {
        subject.setPoisoned(point);
        return true;
    }
}
