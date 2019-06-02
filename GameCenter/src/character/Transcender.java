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
        return new int[]{100, 1, 3, 3, 5, 9, 4, 2, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 100};
    }
}
