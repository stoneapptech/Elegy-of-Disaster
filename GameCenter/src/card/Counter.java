package card;

import card.passive.PassiveCard;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.HashMap;

public class Counter extends PassiveCard {
    @Override
    public String getName() {
        return "反制";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current) {
        return null;
    }

    @Override
    protected int getId() {
        return 23;
    }
}
