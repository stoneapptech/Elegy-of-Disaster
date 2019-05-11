package card.active;

import card.active.ActiveCard;
import effect.DrawCard;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Supply extends ActiveCard {

    @Override
    public String getName() {
        return "補給";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        Effect[] effects = new Effect[]{new DrawCard(2, current)};
        return new ArrayList<>(Arrays.asList(effects));
    }

    @Override
    public int getCost() {
        return 1;
    }

    @Override
    protected int getId() {
        return 3;
    }
}
