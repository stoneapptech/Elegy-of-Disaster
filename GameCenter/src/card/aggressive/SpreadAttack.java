package card.aggressive;

import card.SpecialCard;
import card.active.ActiveCard;
import card.aggressive.AggressiveCard;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.HashMap;

public class SpreadAttack extends ActiveCard implements AggressiveCard, SpecialCard {
    @Override
    public String getName() {
        return "掃射";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        return null;
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
