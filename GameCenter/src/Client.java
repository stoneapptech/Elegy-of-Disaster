abstract class Client {
    abstract void onAttacked();
    abstract void onAskedDraw();
    abstract void onDropCard();
    abstract void fuckOff();
    abstract void onDrawCard();
    abstract void onPoisoned();
    abstract void onDamaged();
    abstract void onHealed();
    abstract void onAskedDefend();
    abstract void onChooseCard();
}

class FuckingClient extends Client {}