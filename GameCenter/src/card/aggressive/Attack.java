package card.aggressive;

import card.active.ActiveCard;
import effect.DamageLife;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Attack extends ActiveCard implements AggressiveCard {

    @Override
    public String getName() {
        return "攻擊";
    }

    @Override
    protected ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        Effect[] effects = {new DamageLife(2, players.get(current))};
        return new ArrayList<>(Arrays.asList(effects));
    }

    @Override
    public int getCost() {
        return 1;
    }

    @Override
    protected int getId() {
        return 1;
    }
}
