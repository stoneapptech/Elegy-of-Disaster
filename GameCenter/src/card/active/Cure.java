package card.active;

import card.active.ActiveCard;
import character.Character;
import client.Client;
import effect.AddLife;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Cure extends ActiveCard {
    @Override
    public String getName() {
        return "治癒";
    }

    @Override
    protected int getId() {
        return 2;
    }

    @Override
    protected ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        Effect[] effects = {new AddLife(2, current)};
        return new ArrayList<>(Arrays.asList(effects));
    }

    @Override
    public int getCost() {
        return 1;
    }
}
