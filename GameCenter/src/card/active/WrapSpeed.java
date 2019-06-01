package card.active;

import card.active.ActiveCard;
import effect.ChangeDefensible;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WrapSpeed extends ActiveCard {
    @Override
    public String getName() {
        return "神速";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {

        Effect[] effects = {new ChangeDefensible(current, false)};
        center.broadcast(current.getCharacter().getName() + "拔出雙刀，變的很快");
        return new ArrayList<>(Arrays.asList(effects));
    }

    @Override
    public int getCost() {
        return 1;
    }

    @Override
    protected int getId() {
        return 8;
    }
}
