package gameCenter;

import client.Client;

public class TwoPlayerGameCenter extends GameCenter {

    @Override
    int getPipesCount() {
        return 2;
    }

    @Override
    int getCost() {
        return 3;
    }
}
