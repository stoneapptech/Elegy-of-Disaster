package card;

import character.Character;
import client.Client;
import effect.AddLife;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Cure extends Card {
    @Override
    public String getName() {
        return "治癒";
    }

    @Override
    protected int getId() {
        return 2;
    }

    @Override
    public void applyEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        for(Effect e: getEffect(current)) {
            e.invoke();
        }
    }

    @Override
    public int getCost() {
        return 1;
    }

    private ArrayList<Effect> getEffect(Pipe subject) {
        Effect[] effects = {new AddLife(2, subject)};
        return new ArrayList<>(Arrays.asList(effects));
    }
}
