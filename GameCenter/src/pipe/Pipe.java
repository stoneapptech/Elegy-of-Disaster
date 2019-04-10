package pipe;

import card.Card;
import character.Character;
import client.Client;
import gameCenter.GameCenter;

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

    public Character getCharacter() {
        return client.getCharacter();
    }


}
