package card;

public class Supply extends Card {

    @Override
    public String getName() {
        return "補給";
    }

    @Override
    protected int getId() {
        return 4;
    }
}
