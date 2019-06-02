package card.aggressive;

import EODObject.Attackable;
import card.SpecialCard;
import card.active.ActiveCard;
import effect.DamageLife;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;
import propperty.Property;

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
        Property p = center.getPropertyOf(opponent);
        Attackable subject = p == null ? opponent:p;
        Effect[] effects = {new DamageLife(6, subject)};
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
