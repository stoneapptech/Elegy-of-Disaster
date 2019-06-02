package character;

import io.Input;
import io.Output;
import pipe.Pipe;

import java.util.HashMap;

public class Spacezipper extends Character {

    public Spacezipper() {
        super(15);
    }
    private int conditionPoint = 0;

    @Override
    public String getName() {
        return "圭月";
    }

    @Override
    int[] getDeckCardsCount() {
        return new int[]{7, 5, 5, 5, 5, 5, 3, 3, 1, 1, 1, 1, 1, 1, 1, 100, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    }

    @Override
    public void onAttackSuccessfully(Output outputMethod, Input inputMethod,
                                     Pipe owner, HashMap<Pipe, Pipe> players) {
        super.onAttackSuccessfully(outputMethod, inputMethod, owner, players);
        conditionPoint++;
//        outputMethod.send("龜月:\n" + "成功攻擊\n" + "請選擇下列一項發動");
//        Effect[][] effects = {
//                {new DamageLife(2, players.get(owner))},
//                {new DamageLife(1, players.get(owner)), new LoseCard(players.get(owner))},
//                {new LoseCard(players.get(owner)), new LoseCard(players.get(owner))}
//        };
    }

    @Override
    public void onDefendSuccessfully(Output outputMethod, Input inputMethod,
                                     Pipe owner, HashMap<Pipe, Pipe> players) {
        super.onDefendSuccessfully(outputMethod, inputMethod, owner, players);
        conditionPoint++;
//        outputMethod.send("圭月:\n" + "成功防禦\n" + "請選擇下列一項發動");
//        Effect[] effects = {
//                new DamageLife(2, players.get(owner)),
//                new AddLife(2, owner),
//                new DrawCard(2, owner)
//        };
//        for(int i = 1; i <= effects.length; i++) {
//            outputMethod.send(i + ". " + effects[i-1].getDescription());
//        }
//        while(true) {
//            try {
//                int num = inputMethod.getNumber();
//                if(num > effects.length) {
//                    continue;
//                }
//                effects[num-1].invoke();
//                break;
//            } catch (Exception e) {
//                //don't need implementation
//            }
//        }
    }

    @Override
    public void onAttackFailed(Output outputMethod, Input inputMethod,
                               Pipe owner, HashMap<Pipe, Pipe> players) {
        super.onAttackFailed(outputMethod, inputMethod, owner, players);
        conditionPoint--;
    }

    @Override
    public void onDefendFailed(Output outputMethod, Input inputMethod,
                               Pipe owner, HashMap<Pipe, Pipe> players) {
        super.onDefendFailed(outputMethod, inputMethod, owner, players);
        conditionPoint--;
    }
}
