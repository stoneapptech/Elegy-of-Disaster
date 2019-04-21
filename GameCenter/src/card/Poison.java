package card;

public class Poison extends Card {
    @Override
    public String getName() {
        return "劇毒";
    }

    @Override
    protected int getId() {
        return 21;
    }
}
