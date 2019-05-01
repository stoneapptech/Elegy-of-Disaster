package card;

import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.HashMap;

public class Dodge extends Card {
    @Override
    public String getName() {
        return "迴避";
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
        return 6;
    }
}
