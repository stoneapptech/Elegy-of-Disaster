package card;

public class Dodge extends Card {
    @Override
    public String getName() {
        return "迴避";
    }

    @Override
    protected int getId() {
        return 7;
    }
}
