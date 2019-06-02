package card.active;

import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.HashMap;

public class EffectStorer extends ActiveCard {
    ArrayList<Effect> remainEffects;
    public EffectStorer(ArrayList<Effect> remainEffects) {
        this.remainEffects = remainEffects;
    }
    @Override
    public String getName() {
        return null;
    }

    @Override
    protected int getId() {
        return 0;
    }

    @Override
    protected ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        return this.remainEffects;
    }

    @Override
    public int getCost() {
        return 0;
    }
}
