package card.active;

import effect.Effect;
import effect.GetSpecial;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Strategy extends ActiveCard {
    @Override
    public String getName() {
        return "妙策";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        Effect[] effects = {new GetSpecial(current)};
        return new ArrayList<>(Arrays.asList(effects));
    }

    @Override
    public int getCost() {
        return 1;
    }

    @Override
    protected int getId() {
        return 7;
    }
}
