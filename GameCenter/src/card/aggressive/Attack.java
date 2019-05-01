package card.aggressive;

import card.Card;
import effect.DamageLife;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Attack extends Card implements AggressiveCard {

    @Override
    public String getName() {
        return "攻擊";
    }

    @Override
    public void applyEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        for(Effect e: getEffects(players.get(current))) {
            e.invoke();
        }
    }

    private ArrayList<Effect> getEffects(Pipe subject) {
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
