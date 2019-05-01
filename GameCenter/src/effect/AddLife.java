package effect;

import character.Character;
import client.Client;
import gameCenter.GameCenter;
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
    public void invoke() {
        subject.increaseLife(life);
    }
}
