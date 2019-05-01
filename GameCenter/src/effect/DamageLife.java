package effect;

import pipe.Pipe;

public class DamageLife extends Effect {

    private Pipe subject;
    private int life;

    public DamageLife(int life, Pipe pipe) {
        this.subject = pipe;
        this.life = life;
    }

    @Override
    public void invoke() {
        subject.decreaseLife(life);
    }
}
