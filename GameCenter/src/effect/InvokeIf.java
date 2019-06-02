package effect;


import java.util.function.Supplier;

public class InvokeIf extends Effect {
    private Supplier<Boolean> supplier;
    private Effect effect;
    private boolean used = false;

    public InvokeIf(Effect effect, Supplier<Boolean> supplier) {
        this.supplier = supplier;
        this.effect = effect;
    }
    @Override
    public boolean invoke() {
        if(supplier.get()) {
            effect.invoke();
            used = true;
        }
        return used;
    }
}
