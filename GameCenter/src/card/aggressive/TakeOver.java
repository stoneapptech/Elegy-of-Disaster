package card.aggressive;

import card.active.ActiveCard;
import card.aggressive.AggressiveCard;
import effect.Effect;
import effect.GetRandomCard;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TakeOver extends ActiveCard implements AggressiveCard {
    @Override
    public String getName() {
        return "強奪";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        Effect[] effects = {new GetRandomCard(current, players.get(current))};
        return new ArrayList<>(Arrays.asList(effects));
    }

    @Override
    public int getCost() {
        return 1;
    }

    @Override
    protected int getId() {
        return 4;
    }
}
