package pipe;

import card.Card;
import character.Character;
import client.Client;
import gameCenter.GameCenter;

import java.util.ArrayList;

public class Pipe {

    private GameCenter center;
    private Client client;
    public void setClient(Client client) {
        this.client = client;
    }

    public Pipe(GameCenter center, Client client) {
        this.center = center;
        this.client = client;
    }
    public Pipe(GameCenter center) {
        this.center = center;
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

    public void requirePlayCard(ArrayList<Card> hand) {
        client.onChooseCard(hand);
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

    @Override
    public String toString() {
        return "Pipe: " + client.getCharacter().getName();
    }
}
