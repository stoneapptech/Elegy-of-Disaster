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
        return null;
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
