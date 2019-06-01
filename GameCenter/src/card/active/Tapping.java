package card.active;

import card.active.ActiveCard;
import effect.LookOpponentCard;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Tapping extends ActiveCard {
    @Override
    public String getName() {
        return "竊聽";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        Effect[] effects = new Effect[]{new LookOpponentCard(3, current)};
        return new ArrayList<>(Arrays.asList(effects));
    }

    @Override
    public int getCost() {
        return 1;
    }

    @Override
    protected int getId() {
        return 12;
    }
}
