package character;

public class Mousetrap extends Character {

    public Mousetrap() {
        super(12);
    }

    @Override
    public String getName() {
        return "W";
    }

    @Override
    int[] getDeckCardsCount() {
        return new int[]{6, 6, 6, 0, 7, 7, 4, 4, 0, 0, 3, 0, 0};
    }
}
