package effect;

import pipe.Pipe;

public class DecreasedDamage extends Effect {
    int point;
    Pipe subject;
    public DecreasedDamage(int point, Pipe subject) {
        this.point = point;
        this.subject = subject;
    }

    @Override
    public boolean invoke() {
        subject.decreasedDamage(point);
        return true;
    }
}
