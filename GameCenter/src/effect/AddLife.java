package effect;

import pipe.Pipe;

public class AddLife extends Effect {

    private Pipe subject;
    private int life;

    //add life only take the first characters as subject
    public AddLife(int life, Pipe pipe) {
        subject = pipe;
        this.life = life;
    }

    @Override
    public String getDescription() {
        return "回復自己" + life + "點生命值";
    }

    @Override
    public void invoke() {
        subject.increaseLife(life);
    }
}
