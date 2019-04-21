package card;

public class Counter extends Card {
    @Override
    public String getName() {
        return "反制";
    }

    @Override
    protected int getId() {
        return 23;
    }
}
