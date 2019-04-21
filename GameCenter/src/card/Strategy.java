package card;

public class Strategy extends Card {
    @Override
    public String getName() {
        return "妙策";
    }

    @Override
    protected int getId() {
        return 8;
    }
}
