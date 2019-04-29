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
        return 3;
    }

    public void applyEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        for(Effect e: getEffect(current)) {
            e.invoke();
        }
    }

    public ArrayList<Effect> getEffect(Pipe subject) {
        Effect[] effects = {new AddLife(subject), new AddLife(subject)};
        return new ArrayList<>(Arrays.asList(effects));
    }
}
