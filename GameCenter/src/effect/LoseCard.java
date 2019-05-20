package effect;

public class LoseCard extends Effect {

    private Pipe opponent;
    public LoseCard(Pipe opponent) {
        this.opponent = opponent;
    }


    @Override
    public void invoke() {
        opponent.loseRandomCard();
    }
}