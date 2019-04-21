package card;

public class Defense extends Card {
    @Override
    public String getName() {
        return "防禦";
    }

    @Override
    protected int getId() {
        return 2;
    }
}
