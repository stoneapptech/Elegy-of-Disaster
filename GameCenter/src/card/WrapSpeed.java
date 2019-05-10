package card;

import card.active.ActiveCard;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.HashMap;

public class WrapSpeed extends ActiveCard {
    @Override
    public String getName() {
        return "神速";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        return null;
    }

    @Override
    public int getCost() {
        return 1;
    }

    @Override
    protected int getId() {
        return 8;
    }
}
