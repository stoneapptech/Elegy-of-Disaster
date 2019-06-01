package pipe;

import EODObject.Cards;
import card.Card;
import card.SpecialCard;
import card.active.ActiveCard;
import card.aggressive.AggressiveCard;
import card.aggressive.Snipe;
import card.passive.PassiveCard;
import character.Character;
import client.Client;
import exceptions.ChooseZeroException;
import gameCenter.GameCenter;

import java.util.HashMap;
import java.util.Random;

public class Pipe {

    private GameCenter center;
    public Client client;
    private Cards cardBuffer = new Cards();

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
    //return whether successfully attacked
    public boolean activateBuffer(Pipe current, HashMap<Pipe, Pipe> players, GameCenter center) {
        for(Card c: cardBuffer) {
            if(c instanceof ActiveCard) {
                ((ActiveCard) c).applyEffects(current, players, center);
            }
            if(c instanceof PassiveCard) {
                ((PassiveCard) c).applyPassiveSkill(current, players, center);
            }
        }
        boolean successfullyAttacked = false;
        if(cardBuffer.filter(x -> x instanceof AggressiveCard).size() > 0) {
            successfullyAttacked = true;
        }
        cardBuffer.clear();
        return successfullyAttacked;
    }
    public void onLoseCard(Card c) {
        client.onLoseCard(c);
    }

    public void onAttackSuccessfully(HashMap<Pipe, Pipe> players) {
        client.onAttackSuccessfully(this, players);
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
    public void addCardToHand(int number, Cards cards) {
        Card c = cards.get(number-1);
        center.addToHand(c, this);
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
        cardBuffer.removeIf(card -> {
            if(card instanceof AggressiveCard) {
                return !(card instanceof Snipe) || new Random().nextBoolean();
            }
            return false;
        });
    }

    public boolean changeDefensible(boolean status) {
        return center.changeDefensible(this, status);
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
    public Card loseRandomCard() {
        return center.loseCardOn(this);
    }
    public Card getCardFromBuffer(int index) {
        if (index < 0) {
            index = cardBuffer.size() + index;
        }
        return cardBuffer.get(index);
    }
    public void addCardToHand(Card c) {
        center.addToHand(c, this);
    }

    @Override
    public String toString() {
        return "Pipe: " + client.getCharacter().getName();
    }

    public void getSpecialFromDeck() {
        Cards specialCards = getCharacter().getDeck().filter(card -> {
            return card instanceof SpecialCard;
        });
        Cards firstThree = new Cards();
        for(int i = 0; i < 3; i++) {
            firstThree.add(specialCards.get(i));
        }
        client.onAskedAddToHand(firstThree);
    }

    public boolean changeAttackable(boolean status) {
        return center.changeAttackable(this, status);
    }

    public boolean getCanAttack() {
        return center.getCanAttack(this);
    }


    public void consumeCost(int cost) {
        client.consumeCost(cost);
    }
    public void showCard(int a) {

    }
}

