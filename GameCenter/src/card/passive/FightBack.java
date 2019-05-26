package card.passive;

import card.SpecialCard;
import card.passive.PassiveCard;
import effect.DamageLife;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FightBack extends PassiveCard implements SpecialCard {
    @Override
    public String getName() {
        return "還擊";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        Effect[] effects = {new DamageLife(4, current)};
        return new ArrayList<>(Arrays.asList(effects));
    }

    @Override
    protected int getId() {
        return 11;
    }
}
