package character;

import EODObject.Cards;
import card.Card;
import io.Input;
import io.Output;
import pipe.Pipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public abstract class Character {

    protected int life;
    protected int poisoned;
    private int damageVariation = 0;

    protected Character(int life) {
        this.life = life;
    }
    public abstract String getName();
    public int getLife() {
        return life;
    }
    abstract int[] getDeckCardsCount();
    public void increaseLife() {
        increaseLifeBy(1);
    }
    public void increaseLifeBy(int num) {
        life += num;
    }
    public void decreaseLife() {
        decreaseLifeBy(1);
    }
    public int decreaseLifeBy(int num) {
        num = num + damageVariation;
        life -= num;
        return num;
    }

    public void onDefendSuccessfully(Output outputMethod, Input inputMethod,
                                     Pipe owner, HashMap<Pipe, Pipe> players) {}
    public void onAttackSuccessfully(Output outputMethod, Input inputMethod,
                                     Pipe owner, HashMap<Pipe, Pipe> players) {}
    public void onDefendFailed(Output outputMethod, Input inputMethod,
                               Pipe owner, HashMap<Pipe, Pipe> players) {}
    public void onAttackFailed(Output outputMethod, Input inputMethod,
                               Pipe owner, HashMap<Pipe, Pipe> players) {}

    //lazy init
    private Cards deck = null;
    public Cards getDeck() {
        if(deck == null) {
            ArrayList<Card> initialDeck = new ArrayList<Card>() {{
                String[] cards = {"aggressive.Attack",
                        "active.Cure",
                        "active.Supply",
                        "aggressive.TakeOver",
                        "aggressive.QuickAttack",
                        "passive.Dodge",
                        "active.Strategy",
                        "active.WrapSpeed",
                        "active.Hidden",
                        "aggressive.Kill",
                        "passive.FightBack",
                        "active.Tapping",
                        "active.Ease",
                        "aggressive.Snipe",
                        "active.Grenade",
                        "active.Wall",
                        "active.Smoke",
                        "active.ArmorOff",
                        "aggressive.SpreadAttack",
                        "active.Bless",
                        "active.Poison",
                        "active.Mad",
                        "passive.Counter",
                        "active.Team",
                        "active.Backstab",
                        "aggressive.DoubleAttack",
                        "active.Seperation"};
                for (int i = 0; i < getDeckCardsCount().length; i++) {
                    for (int j = 0; j < getDeckCardsCount()[i]; j++) {
                        try {
                            add((Card) Class.forName("card." + cards[i]).newInstance());
                        } catch (Exception e) {
                            //don't have to do anything
                            //this won't happen
                        }
                    }
                }
            }};
            Collections.shuffle(initialDeck);
            deck = new Cards(initialDeck);
        }
        return deck;
    }

    public int getPoisoned() {
        return poisoned;
    }

    public void increasePoisoned(int point) {
        poisoned += point;
    }
    public void restorePoisoned() {
        poisoned = 0;
    }

    public void setDamageVariation(int point) {
        damageVariation += point;
    }
}
