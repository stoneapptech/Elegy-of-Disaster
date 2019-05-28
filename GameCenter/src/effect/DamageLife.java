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
    public String getDescription() {
        return "給予敵方" + life + "點傷害";
    }

    @Override
    public void invoke() {
        subject.decreaseLife(life);
    }
}
