package card.aggressive;

import card.active.ActiveCard;
import effect.DamageLife;
import effect.Effect;
import effect.LoseCard;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class QuickAttack extends ActiveCard implements AggressiveCard {
    @Override
    public String getName() {
        return "奇襲";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        Pipe opponent = players.get(current);
        Effect[] effects = {new DamageLife(1, opponent), new LoseCard(1, opponent)};
        return new ArrayList<>(Arrays.asList(effects));
    }

    @Override
    public int getCost() {
        return 1;
    }

    @Override
    protected int getId() {
        return 5;
    }
}
