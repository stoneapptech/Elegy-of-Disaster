package card.aggressive;

import card.SpecialCard;
import card.active.ActiveCard;
import card.aggressive.AggressiveCard;
import effect.DamageLife;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Snipe extends ActiveCard implements AggressiveCard, SpecialCard {
    @Override
    public String getName() {
        return "狙擊";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        Pipe opponent = players.get(current);
        Effect[] effects = {new DamageLife(6, opponent)};
        return new ArrayList<>(Arrays.asList(effects));
    }

    @Override
    public int getCost() {
        return 3;
    }

    @Override
    protected int getId() {
        return 14;
    }
}
