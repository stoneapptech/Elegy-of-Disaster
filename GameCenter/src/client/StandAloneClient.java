package client;

import EODObject.Cards;
import card.Card;
import card.active.ActiveCard;
import card.passive.PassiveCard;
import character.Character;
import exceptions.ChooseZeroException;
import io.Input;
import io.Output;

import java.util.ArrayList;
import java.util.function.Predicate;

public class StandAloneClient extends Client {

    public StandAloneClient(Character character, Output output, Input input) {
        super(character, output, input);
    }

    @Override
    public void onAskedAddToHand(ArrayList<Card> cards) {
        outputMethod.send("請從以下選取一張加入手牌");
        for (int i = 0; i < cards.size(); i++) {
            outputMethod.send((i + 1) + "." + cards.get(i).getName());
        }
        while(true) {
            int num = inputMethod.getNumber();
            if(num > 0 && num <= cards.size()) {
                pipe.addCardToHand(num);
                break;
            }
        }
    }

    @Override
    public void onDropCard(Card card) {
        outputMethod.send(character.getName() + ":\n" + character.getName() + "掉了" + card.getName());
    }

    @Override
    public void fuckOff() {

    }

    @Override
    public void onPoisoned() {
        outputMethod.send(character.getName() + ":\n" + character.getName() + "中毒了");
    }

    @Override
    public void onDamaged(int damage) {
        character.decreaseLifeBy(damage);
        outputMethod.send(character.getName() + ":\n" + character.getName() + "受到" + damage +"點傷害");
    }

    @Override
    public void onHealed(int life) {
        character.increaseLifeBy(life);
        outputMethod.send(character.getName() + ":\n" + character.getName() + "回覆了" + life +"點生命");
    }

    @Override
    public void onAskedDefend(Cards handDefensive) {
        outputMethod.send(character.getName() + ":\n" + "請問要防禦嗎？不防禦請輸入0 ");
        showCards(handDefensive, card -> card instanceof PassiveCard, "");
        while(true) {
            int num = inputMethod.getNumber();
            if(num == 0) {
                break;
            } else if(num > 0 && num <= handDefensive.size()) {
                pipe.playDefensiveCard(num);
                break;
            }
        }
    }

    @Override
    public void onChooseCard(Cards hand) throws ChooseZeroException {
        showCards(hand, card -> card instanceof ActiveCard, "不可出");
        while(true) {
            int num = inputMethod.getNumber();
            if(num == 0) {
                throw new ChooseZeroException();
            } else if(num > 0 && num <= hand.size()) {
                if(hand.get(num-1) instanceof PassiveCard) {
                    continue;
                }
                cost -= ((ActiveCard)hand.get(num-1)).getCost();
                pipe.playCard(num);
                break;
            }
        }
    }

    private void showCards(Cards cards, Predicate<? super Card> predicate, String message) {
        for(int i = 0; i < cards.size(); i++) {
            String output = (i+1) + "." + cards.get(i).getName();
            if(!predicate.test(cards.get(i))) {
                output += "(" + message + ")";
            }
            outputMethod.send(output);
        }
    }

    private void showCards(Cards cards) {
        showCards(cards, x -> true, "");
    }

    @Override
    public void onReceivedCard(Card card) {
        outputMethod.send(character.getName() + ":\n" + character.getName() + "抽到了" + card.getName());
}

    @Override
    public void onNextTurn() {
        super.onNextTurn();
        outputMethod.send(character.getName() + ":\n" + character.getName() + "的第" + turn + "回合");
    }

    @Override
    public void onLoseCard(Card c) {
        outputMethod.send(character.getName() +":\n" + character.getName() + "損失了" + c.getName());
    }
}
