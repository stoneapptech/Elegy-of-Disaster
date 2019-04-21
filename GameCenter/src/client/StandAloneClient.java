package client;

import card.Card;
import character.Character;
import io.Input;
import io.Output;

import java.util.ArrayList;

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
        outputMethod.send(character.getName() + "掉了" + card.getName());
    }

    @Override
    public void fuckOff() {

    }

    @Override
    public void onPoisoned() {
        outputMethod.send(character.getName() + "中毒了");
    }

    @Override
    public void onDamaged(int damage) {
        outputMethod.send(character.getName() + "受到" + damage +"點傷害");
    }

    @Override
    public void onHealed(int life) {
        outputMethod.send(character.getName() + "回覆了" + life +"點生命");
    }

    @Override
    public void onAskedDefend(ArrayList<Card> handDefensive) {
        outputMethod.send("請問要防禦嗎？不防禦請輸入0 ");
        for (int i = 0; i < handDefensive.size(); i++) {
            outputMethod.send((i + 1) + "." + handDefensive.get(i).getName());
        }
        while(true) {
            int num = inputMethod.getNumber();
            if(num == 0) {
                break;
            } else if(num > 0 && num <= handDefensive.size()) {
                pipe.playDefensiveCard(num);
            }
        }
    }

    @Override
    public void onChooseCard(ArrayList<Card> hand) {
        for (int i = 0; i < hand.size(); i++) {
            outputMethod.send((i + 1) + "." + hand.get(i).getName());
        }
        while(true) {
            int num = inputMethod.getNumber();
            if(num == 0) {
                break;
            } else if(num > 0 && num <= hand.size()) {
                pipe.playCard(num);
            }
        }
    }

    @Override
    public void onReceivedCard(Card card) {
        outputMethod.send(character.getName() + "抽到了" + card.getName());
}

    @Override
    public void onNextTurn() {
        super.onNextTurn();
        outputMethod.send(character.getName() + "的第" + turn + "回合");
    }
}
