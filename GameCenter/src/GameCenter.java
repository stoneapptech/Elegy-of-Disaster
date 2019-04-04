abstract class GameCenter {
    abstract void playCard(Card card);

    Pipe pipe = new Pipe(this);
}
