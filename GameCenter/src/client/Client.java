package client;

import card.Card;
import character.Character;
import io.Input;
import io.Output;
import pipe.Pipe;

import java.util.ArrayList;

public abstract class Client {

    protected Character character;
    public Character getCharacter() {
        return character;
    }
    protected Output outputMethod;
    protected Input inputMethod;
    protected int turn = 0;
    public Pipe pipe;

    Client(Character character, Output outputMethod, Input inputMethod) {
        this.character = character;
        this.outputMethod = outputMethod;
        this.inputMethod = inputMethod;
    }

    public abstract void onAttacked();
    public abstract void onAskedDraw();
    public abstract void onDropCard();
    public abstract void fuckOff();
    public abstract void onDrawCard();
    public abstract void onPoisoned();
    public abstract void onDamaged();
    public abstract void onHealed();
    public abstract void onAskedDefend();
    public abstract void onChooseCard(ArrayList<Card> hand);
    public abstract void onReceivedCard(Card card);
    public void onNextTurn() {
        turn++;
    }

    public void displayLife() {
        outputMethod.send("生命值: " + character.getLife());
    }
    public void onMessage(String message) {
        outputMethod.send(message);
    }
    public int getCharacterLife() {
        return character.getLife();
    }
}