package card;

import card.active.ActiveCard;
import effect.Effect;
import gameCenter.GameCenter;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.HashMap;

public class Strategy extends ActiveCard {
    @Override
    public String getName() {
        return "妙策";
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
        return 7;
    }
}
