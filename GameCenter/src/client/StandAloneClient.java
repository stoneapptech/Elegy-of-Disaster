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
    public void onAttacked() {

    }

    @Override
    public void onAskedDraw() {

    }

    @Override
    public void onDropCard() {

    }

    @Override
    public void fuckOff() {

    }

    @Override
    public void onDrawCard() {

    }

    @Override
    public void onPoisoned() {

    }

    @Override
    public void onDamaged() {

    }

    @Override
    public void onHealed() {

    }

    @Override
    public void onAskedDefend() {

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
