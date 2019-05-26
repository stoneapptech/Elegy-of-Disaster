package card.passive;

import card.Card;
import effect.Effect;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class PassiveCard extends Card {

    protected abstract ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center);

    public void applyPassiveSkill(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        for(Effect e: getEffects(current, players, center)) {
            e.invoke();
        }
    }
}
