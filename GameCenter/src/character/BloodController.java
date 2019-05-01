package character;

public class BloodController extends Character {

    public BloodController() {
        super(15);
    }

    @Override
    public String getName() {
        return "梅";
    }

    @Override
    int[] getDeckCardsCount() {
        return new int[]{7, 5, 5, 5, 5, 5, 3, 3, 1, 1, 1, 1, 1};
    }
}
