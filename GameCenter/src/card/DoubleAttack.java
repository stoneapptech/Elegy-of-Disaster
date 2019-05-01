package card;

import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.HashMap;

public class DoubleAttack extends Card {
    @Override
    public String getName() {
        return "夾擊";
    }

    @Override
    public void applyEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {

    }

    @Override
    public int getCost() {
        return 2;
    }

    @Override
    protected int getId() {
        return 26;
    }
}
