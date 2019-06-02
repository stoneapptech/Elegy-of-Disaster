package character;

public class Transcender extends Character {

    public Transcender() {
        super(12);
    }

    @Override
    public String getName() {
        return "小兔";
    }

    @Override
    int[] getDeckCardsCount() {
        return new int[]{7, 5, 5, 5, 5, 5, 3, 3, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 10, 0, 1, 0, 0, 0, 0};
    }
}
