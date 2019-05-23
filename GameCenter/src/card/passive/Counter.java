package card.passive;

import card.SpecialCard;
import effect.Effect;
import pipe.Pipe;

import java.util.ArrayList;

public class Counter extends PassiveCard implements SpecialCard {
    @Override
    public String getName() {
        return "反制";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current) {
        return null;
    }

    @Override
    protected int getId() {
        return 23;
    }
}
