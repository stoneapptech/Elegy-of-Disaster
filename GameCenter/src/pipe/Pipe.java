package pipe;

import EODObject.Cards;
import card.Card;
import card.active.ActiveCard;
import card.aggressive.AggressiveCard;
import card.passive.PassiveCard;
import character.Character;
import client.Client;
import effect.Effect;
import exceptions.ChooseZeroException;
import gameCenter.GameCenter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;

public class Pipe {

    private GameCenter center;
    public Client client;
    private ArrayList<Card> cardBuffer = new ArrayList<>();

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
    public void receivedCards(Cards cards) {
        for(Card c: cards) {
            client.onReceivedCard(c);
        }
    }
    public void startNextTurn() {
        client.onNextTurn();
    }
    public void displayLife() {
        client.displayLife();
    }
    public void requirePlayCard(Cards hand) throws ChooseZeroException {
        client.onChooseCard(hand);
    }
    public int getAvailableCost() {
        return client.getAvailableCost();
    }
    public void askDefend(Cards cards) {
        client.onAskedDefend(cards);
    }
    public void activateBuffer(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        for(Card c: cardBuffer) {
            if(c instanceof ActiveCard) {
                ((ActiveCard) c).applyEffects(current, players, center);
            }
            if(c instanceof PassiveCard) {
                ((PassiveCard) c).applyPassiveSkill(current);
            }
        }
    }

    //method for Client
    //which means it interact with GameCenter
    //this number represent the index of card(start from 1)
    public void playCard(int number) {
        center.onClientPlayCard(number);
    }
    public void playDefensiveCard(int number) {
        center.onClientPlayDefensive(number);
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

    public void invalidateAggressive() {
        cardBuffer.removeIf(card -> card instanceof AggressiveCard);
    }

    public void drawCard(int num) {
        center.onAskedToDrawCard(num);
    }

    public void insertCardToBufferHead(Card c) {
        cardBuffer.add(0, c);
    }
    public void appendCardToBuffer(Card c) {
        cardBuffer.add(c);
    }

    @Override
    public String toString() {
        return "Pipe: " + client.getCharacter().getName();
    }
}
