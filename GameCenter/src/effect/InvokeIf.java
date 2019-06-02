package effect;


import java.util.function.Supplier;

public class InvokeIf extends Effect {
    private Supplier<Boolean> supplier;
    private Effect effect;
    //indicate how long to observe
    //the time unit is every time invoke is called
    //if waitingTime == 0 then shouldDisappear will be true
    //if waitingTime is assigned to -1, it's infinitive
    private int waitingTime;

    public InvokeIf(Effect effect, Supplier<Boolean> supplier, int time) {
        this.supplier = supplier;
        this.effect = effect;
        this.waitingTime = time;
    }
    @Override
    public boolean invoke() {
        if(waitingTime == 0) {
            return true;
        }
        if(supplier.get()) {
            effect.invoke();
            return true;
        }
        waitingTime--;
        return false;
    }
}
