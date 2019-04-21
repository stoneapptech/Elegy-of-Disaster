package card;

public class Attack extends Card {
    @Override
    public String getName() {
        return "攻擊";
    }

    @Override
    protected int getId() {
        return 1;
    }
}
