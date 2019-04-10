package client;

import character.Character;

public abstract class Client {

    Client(Character character) {
        this.character = character;
    }

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

    private Character character;
    public Character getCharacter() {
        return character;
    }
}