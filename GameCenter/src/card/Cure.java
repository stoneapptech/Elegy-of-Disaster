package card;

public class Cure extends Card {
    @Override
    public String getName() {
        return "治癒";
    }

    @Override
    protected int getId() {
        return 3;
    }
}
