package pipe;

import java.util.ArrayList;

public class Pipes extends ArrayList<Pipe> {

    public void broadcast(String message) {
        for(Pipe p: this) {
            p.send(message);
        }
    }
    public int[] askingForLifes() {
        int[] lifes = new int[this.size()];
        for(int i = 0; i < this.size(); i++) {
            lifes[i] = get(i).askingForLife();
        }
        return lifes;
    }
}
