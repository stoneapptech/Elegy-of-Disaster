package card.active;

import card.active.ActiveCard;
import effect.ChangeAttackable;
import effect.DrawCard;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Ease extends ActiveCard {
    @Override
    public String getName() {
        return "從容";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        Effect[] effects = new Effect[]{new DrawCard(, current)};
        return new ArrayList<>(Arrays.asList(effects));;
    }

    @Override
    public int getCost() {
        return 1;
    }

    @Override
    protected int getId() {
        return 13;
    }
}
