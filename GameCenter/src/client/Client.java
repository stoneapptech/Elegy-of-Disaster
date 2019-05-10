package client;

import EODObject.Cards;
import card.Card;
import character.Character;
import exceptions.ChooseZeroException;
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
    protected int cost = 0;
    public Pipe pipe;

    Client(Character character, Output outputMethod, Input inputMethod) {
        this.character = character;
        this.outputMethod = outputMethod;
        this.inputMethod = inputMethod;
    }

    public abstract void onAskedAddToHand(ArrayList<Card> cards);
    public abstract void onDropCard(Card card);
    public abstract void fuckOff();
    public abstract void onPoisoned();
    public abstract void onDamaged(int damage);
    public abstract void onHealed(int life);
    public abstract void onAskedDefend(Cards handDefensive);
    public abstract void onChooseCard(Cards hand) throws ChooseZeroException;
    public abstract void onReceivedCard(Card card);
    public void onNextTurn() {
        turn++;
        cost = turn>2 ? 3:turn;
    }

    public int getAvailableCost() {
        return cost;
    }
    public void displayLife() {
        outputMethod.send("生命值: " + character.getLife());
    }
    public void onMessage(String message) {
        outputMethod.send(character.getName() + ":\n" + message);
    }
    public int getCharacterLife() {
        return character.getLife();
    }
}