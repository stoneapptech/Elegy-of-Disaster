package card.passive;

import card.Card;
import card.SpecialCard;
import effect.Effect;
import effect.InvalidateAggressive;
import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Counter extends PassiveCard implements SpecialCard {
    @Override
    public String getName() {
        return "反制";
    }

    @Override
    public ArrayList<Effect> getEffects(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        Pipe opponent = players.get(current);
        Card c = current.getCardFromBuffer(-1);
        opponent.insertCardToBufferHead(c);
        opponent.activateBuffer(opponent, players, center);
        Effect[] effects = {new InvalidateAggressive(current)};
        return new ArrayList<>(Arrays.asList(effects));
    }

    @Override
    protected int getId() {
        return 23;
    }
}
