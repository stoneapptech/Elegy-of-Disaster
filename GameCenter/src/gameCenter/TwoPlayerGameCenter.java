package gameCenter;

import client.Client;

public class TwoPlayerGameCenter extends GameCenter {

    public TwoPlayerGameCenter() {
        super();
    }

    public TwoPlayerGameCenter(Client... clients) {
        super(clients);
    }

    @Override
    int getPipesCount() {
        return 2;
    }
}
