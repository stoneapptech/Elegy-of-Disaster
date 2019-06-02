package card.aggressive;

import EODObject.Attackable;
import card.active.ActiveCard;
import effect.DamageLife;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;
import propperty.Property;

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
        Pipe opponent = players.get(current);
        Property p = center.getPropertyOf(opponent);
        Attackable subject = p == null ? opponent:p;
        Effect[] effects = {new DamageLife(2, subject)};
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
