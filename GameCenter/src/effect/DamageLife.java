package effect;

import EODObject.Attackable;

public class DamageLife extends Effect {

    private Attackable subject;
    private int life;

    public DamageLife(int life, Attackable attackable) {
        this.subject = attackable;
        this.life = life;
    }


    @Override
    public String getDescription() {
        return "給予敵方" + life + "點傷害";
    }

    @Override
    public boolean invoke() {
        subject.decreaseLife(life);
        return true;
    }
}
