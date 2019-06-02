package card.passive;

import effect.Effect;
import effect.InvalidateAggressive;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Dodge extends PassiveCard {
    @Override
    public String getName() {
        return "迴避";
    }

    @Override
    protected int getId() {
        return 6;
    }

    @Override
    protected ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        Effect[] effects = {new InvalidateAggressive(current)};
        center.broadcast(players.get(current).getCharacter().getName() + "縱身一躍，躲過了攻擊");
        return new ArrayList<>(Arrays.asList(effects));
    }
}
