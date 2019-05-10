package card.passive;

import card.Card;
import effect.Effect;
import pipe.Pipe;

import java.util.ArrayList;

public abstract class PassiveCard extends Card {

    protected abstract ArrayList<Effect> getEffects(Pipe current);

    public void applyPassiveSkill(Pipe current) {
        for(Effect e: getEffects(current)) {
            e.invoke();
        }
    }
}
