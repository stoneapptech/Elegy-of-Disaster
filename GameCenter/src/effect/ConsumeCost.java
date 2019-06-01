package effect;

import pipe.Pipe;

public class ConsumeCost extends Effect {
    private int cost;
    private Pipe current;
    public ConsumeCost(int cost, Pipe current) {
        this.cost = cost;
        this.current = current;
    }

    @Override
    public boolean invoke() {
        current.consumeCost(cost);
        return true;
    }
}
