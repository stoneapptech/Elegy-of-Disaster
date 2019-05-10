package card;

import gameCenter.GameCenter;
import pipe.Pipe;

import java.util.HashMap;

public abstract class Card {
    public abstract String getName();
    protected abstract int getId();

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Card) {
            Card other = (Card)obj;
            return this.getId() == other.getId();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getId();
    }
}
