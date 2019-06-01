package card.active;

import card.SpecialCard;
import effect.*;
import gameCenter.GameCenter;
import pipe.Pipe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Supplier;

public class Bless extends ActiveCard implements SpecialCard {
    @Override
    public String getName() {
        return "加護";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        Effect[] effects = {new RemoveNegative(current), new DecreasedDamage(1, current), new InvokeIf(new IncreasedDamage(1, current), new Supplier<Boolean>() {
            int turn = 0;
            @Override
            public Boolean get() {
                turn++;
                return turn == 3;
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
        return 20;
    }
}
