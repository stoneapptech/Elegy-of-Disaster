package character;

public class GodSight extends Character {

    public GodSight() {
        super(15);
    }

    @Override
    public String getName() {
        return "安";
    }

    @Override
    int[] getDeckCardsCount() {
        return new int[]{7, 5, 5, 5, 3, 7, 2, 2, 5, 1, 0, 0, 1};
    }
}
