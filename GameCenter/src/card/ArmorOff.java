package card;

import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.HashMap;

public class ArmorOff extends Card {
    @Override
    public String getName() {
        return "卸甲";
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
        return 18;
    }
}
