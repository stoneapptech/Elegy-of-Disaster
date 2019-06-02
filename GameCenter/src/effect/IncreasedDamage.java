package effect;

import pipe.Pipe;

public class IncreasedDamage extends Effect {
    int point;
    Pipe subject;
    public IncreasedDamage(int point, Pipe subject) {
        this.point = point;
        this.subject = subject;
    }

    @Override
    public boolean invoke() {
        subject.IncreasedDamage(point);
        return true;
    }
}
