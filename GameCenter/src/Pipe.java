public class Pipe {

    private GameCenter center;
    private Client client;
    public void setClient(Client client) {
        this.client = client;
    }

    public Pipe(GameCenter center, Client client) {
        this.center = center;
        this.client = client;
    }

    public Pipe(GameCenter center) {
        this.center = center;
    }

    //message methods
    //message to client
    public void sendAttacked() {
        client.attacked();
    }

    //message to center
    public void playCard(Card card) {
        center.playCard(card);
    }


}
