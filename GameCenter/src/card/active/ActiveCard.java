package card.active;

import card.Card;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ActiveCard extends Card {
    public ArrayList<Effect> applyEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        ArrayList<Effect> effects = new ArrayList<>();
        for(Effect e: getEffects(current, players, center)) {
            if(!e.invoke()) {
                effects.add(e);
            }
        }
        return effects;
    }
    protected abstract ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center);
    public abstract int getCost();
}
