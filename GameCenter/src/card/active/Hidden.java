package card.active;

import card.active.ActiveCard;
import effect.ChangeAttackable;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Hidden extends ActiveCard {
    @Override
    public String getName() {
        return "匿蹤";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        Pipe opponent = players.get(current);
        Effect[] effects = {new ChangeAttackable(opponent, false)};
        current.send(current.getCharacter().getName() + "默默的蹲了下去");
        return new ArrayList<>(Arrays.asList(effects));

    }


    @Override
    public int getCost() {
        return 1;
    }

    @Override
    protected int getId() {
        return 9;
    }
}
