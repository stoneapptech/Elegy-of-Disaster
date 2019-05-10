package card;

import card.active.ActiveCard;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.HashMap;

public class ArmorOff extends ActiveCard {
    @Override
    public String getName() {
        return "卸甲";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        return null;
    }

    @Override
    public int getCost() {
        return 2;
    }

    @Override
    protected int getId() {
        return 18;
    }
}
