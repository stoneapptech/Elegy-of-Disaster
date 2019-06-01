package card.active;

import card.SpecialCard;
import card.aggressive.AggressiveCard;
import effect.Effect;
import effect.InvokeIf;
import effect.Poisoning;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Supplier;

public class Poison extends ActiveCard implements SpecialCard {
    @Override
    public String getName() {
        return "劇毒";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        Pipe opponent = players.get(current);
        Effect[] effects = {new InvokeIf(new Poisoning(1, opponent), new Supplier<Boolean>() {
            @Override
            public Boolean get() {
                return current.getCardFromBuffer(-1) instanceof AggressiveCard;
            }
        })};
        return new ArrayList<>(Arrays.asList(effects));
    }

    @Override
    public int getCost() {
        return 1;
    }

    @Override
    protected int getId() {
        return 21;
    }
}
