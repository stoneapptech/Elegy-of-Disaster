package card.active;

import card.SpecialCard;
import effect.AddCardToHand;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Grenade extends ActiveCard implements SpecialCard {
    @Override
    public String getName() {
        return "榴彈";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        Effect[] effects = {new AddCardToHand(this, players.get(current))};
        return new ArrayList<>(Arrays.asList(effects));
    }

    @Override
    public int getCost() {
        return 1;
    }

    @Override
    protected int getId() {
        return 15;
    }
}
