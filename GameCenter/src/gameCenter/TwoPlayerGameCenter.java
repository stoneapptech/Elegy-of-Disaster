package gameCenter;

import client.Client;

import java.util.stream.IntStream;

public class TwoPlayerGameCenter extends GameCenter {

    @Override
    int getPipesCount() {
        return 2;
    }

    @Override
    boolean gameShouldEnd() {
        return IntStream.of(pipes.askingForLifes()).anyMatch(x -> x < 0);
    }
}
