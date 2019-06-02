package card.aggressive;

import card.SpecialCard;
import card.active.ActiveCard;
import effect.DamageLife;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class SpreadAttack extends ActiveCard implements AggressiveCard, SpecialCard {
    @Override
    public String getName() {
        return "掃射";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        int attackTime = new Random().nextInt(6);
        Effect[] effects = new Effect[attackTime];
        Arrays.fill(effects, new DamageLife(1, players.get(current)));
        return new ArrayList<>(Arrays.asList(effects));
    }

    @Override
    public int getCost() {
        return 1;
    }

    @Override
    protected int getId() {
        return 19;
    }
}
