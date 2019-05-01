package card;

import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.HashMap;

public class TakeOver extends Card {
    @Override
    public String getName() {
        return "強奪";
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
        return 4;
    }
}
