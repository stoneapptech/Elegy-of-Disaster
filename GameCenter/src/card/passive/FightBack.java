package card.passive;

import card.SpecialCard;
import card.passive.PassiveCard;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.HashMap;

public class FightBack extends PassiveCard implements SpecialCard {
    @Override
    public String getName() {
        return "還擊";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current) {
        return null;
    }

    @Override
    protected int getId() {
        return 11;
    }
}
