package card.aggressive;

import card.active.ActiveCard;
import card.aggressive.AggressiveCard;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.HashMap;

public class QuickAttack extends ActiveCard implements AggressiveCard {
    @Override
    public String getName() {
        return "奇襲";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        Pipe opponent = players.get(current);
        Effect[] effects = {new DamageLife(1, opponent), new LoseCard(opponent)};
        return new ArrayList(Arrays.asList(effects));
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
