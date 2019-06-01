package character;

public class AtmosphereMaster extends Character {

    public AtmosphereMaster() {
        super(15);
    }

    @Override
    public String getName() {
        return "銀";
    }

    @Override
    int[] getDeckCardsCount() {
        return new int[]{5, 3, 5, 5, 7, 5, 3, 5, 0, 2, 0, 0, 2};
    }
}
