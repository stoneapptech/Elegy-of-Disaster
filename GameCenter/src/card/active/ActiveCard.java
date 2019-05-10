package card.active;

import card.Card;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public abstract class ActiveCard extends Card {
    public void applyEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        for(Effect e: getEffects(current, players, center)) {
            e.invoke();
        }
    }
    protected abstract ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center);
    public abstract int getCost();
}
