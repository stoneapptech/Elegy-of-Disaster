package propperty;

public class Wall extends Property {

    private int stability = 3;

    @Override
    public boolean shouldDisappear() {
        return stability <= 0;
    }

    @Override
    public void decreaseLife(int num) {
        stability -= num;
    }
}
