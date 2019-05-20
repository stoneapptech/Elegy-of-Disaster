package card.aggressive;

import card.active.ActiveCard;
import card.aggressive.AggressiveCard;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.HashMap;

public class DoubleAttack extends ActiveCard implements AggressiveCard {
    @Override
    public String getName() {
        return "夾擊";
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
        return 26;
    }
}
