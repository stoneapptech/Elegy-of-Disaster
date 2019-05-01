package card;

import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.HashMap;

public class Snipe extends Card {
    @Override
    public String getName() {
        return "狙擊";
    }

    @Override
    public void applyEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {

    }

    @Override
    public int getCost() {
        return 3;
    }

    @Override
    protected int getId() {
        return 14;
    }
}
