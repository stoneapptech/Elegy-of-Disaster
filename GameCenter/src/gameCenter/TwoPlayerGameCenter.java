package gameCenter;

import client.Client;
import exceptions.NoOneLostException;
import pipe.Pipe;

import java.util.stream.IntStream;

public class TwoPlayerGameCenter extends GameCenter {

    @Override
    int getPipesCount() {
        return 2;
    }

    @Override
    boolean gameShouldEnd() {
        return IntStream.of(pipes.askingForLifes()).anyMatch(x -> x <= 0);
    }

    @Override
    Pipe getLost() throws NoOneLostException {
        try {
            int lose = IntStream.of(pipes.askingForLifes()).filter(x -> x <= 0).toArray()[0];
            return pipes.get(lose);
        } catch (IndexOutOfBoundsException e) {
            throw new NoOneLostException();
        }
    }
}
