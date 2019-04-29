package effect;

import character.Character;
import client.Client;
import gameCenter.GameCenter;
import pipe.Pipe;

public class AddLife extends Effect {

    private Pipe subject;

    //add life only take the first characters as subject
    public AddLife(Pipe... pipes) {
        subject = pipes[0];
    }

    @Override
    public void invoke() {
        subject.increaseLife(1);
    }
}
