package card;

import org.jetbrains.annotations.Contract;

public abstract class Card {
    public abstract String getName();
    protected abstract int getId();

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Card)) {
            return false;
        }
        Card other = (Card)obj;
        return this.getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return this.getId();
    }
}
