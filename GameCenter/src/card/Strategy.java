package card;

import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.HashMap;

public class Strategy extends Card {
    @Override
    public String getName() {
        return "妙策";
    }

    @Override
    public void applyEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {

    }

    @Override
    public int getCost() {
        return 1;
    }

    @Override
    protected int getId() {
        return 7;
    }
}
