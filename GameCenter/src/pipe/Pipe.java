package pipe;

import card.Card;
import character.Character;
import client.Client;
import exceptions.ChooseZeroException;
import gameCenter.GameCenter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Pipe {

    private GameCenter center;
    public Client client;

    public Pipe(GameCenter center, Client client) {
        this.center = center;
        this.client = client;
    }

    //method for GameCenter
    //which means it interact with client
    public Character getCharacter() {
        return client.getCharacter();
    }
    public void send(String message) {
        client.onMessage(message);
    }
    public int askingForLife() {
        return client.getCharacterLife();
    }
    public void receivedCard(Card card) {
        client.onReceivedCard(card);
    }
    public void startNextTurn() {
        client.onNextTurn();
    }
    public void displayLife() {
        client.displayLife();
    }
    public void requirePlayCard(ArrayList<Card> hand) throws ChooseZeroException {
        client.onChooseCard(hand);
    }
    public int getAvailableCost() {
        return client.getAvailableCost();
    }

    //method for Client
    //which means it interact with GameCenter
    //this number represent the index of card(start from 1)
    public void playCard(int number) {
        center.onClientPlayCard(number);
    }
    public void playDefensiveCard(int number) {

    }
    public void addCardToHand(int number) {

    }

    //method for Effect and Card
    //which means it interact with Client
    //Caution: these methods might change Client's property
    //Use them properly to avoid unpredictable results
    public void increaseLife(int num) {
        client.onHealed(num);
        center.characterHealed(num, this);
    }

    public void decreaseLife(int num) {
        client.onDamaged(num);
    }

    @Override
    public String toString() {
        return "Pipe: " + client.getCharacter().getName();
    }
}
