package game;

import character.*;
import character.Character;
import client.Client;
import client.StandAloneClient;
import gameCenter.GameCenter;
import gameCenter.TwoPlayerGameCenter;
import io.Input;
import io.Output;
import io.StandAloneInputMethod;
import io.StandAloneOutputMethod;

import java.lang.reflect.Constructor;
import java.util.Random;

public class Start {

    private static String[] characterNames = {
            "圭月",
            "小兔",
            "梅",
            "雪村",
            "海爾",
            "安",
            "桑德",
            "銀",
            "W",
            "正作",
            "卡夫卡"
    };
    private static Constructor[] characterConstructors;

    static {
        try {
            characterConstructors = new Constructor[]{
                    Spacezipper.class.getConstructor(),
                    Transcender.class.getConstructor(),
                    BloodController.class.getConstructor(),
                    FrozenHeart.class.getConstructor(),
                    FlamedHeart.class.getConstructor(),
                    GodSight.class.getConstructor(),
                    SoulTaker.class.getConstructor(),
                    AtmosphereMaster.class.getConstructor(),
                    Mousetrap.class.getConstructor(),
                    DoubleReturn.class.getConstructor(),
                    PuppetHouse.class.getConstructor()
            };
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Output outputMethod = new StandAloneOutputMethod();
        Input inputMethod = new StandAloneInputMethod();

        outputMethod.send("角色列表：");
        for(int i = 0; i < characterNames.length; i++) {
            outputMethod.send(i + ". " + characterNames[i]);
        }

        Character player1;
        Character player2;

        while(true) {
            outputMethod.send("玩家一，選擇你的角色");
            try {
                int id = inputMethod.getNumber();
                player1 = (Character)characterConstructors[id-1].newInstance();
                characterConstructors[id - 1] = null;
                outputMethod.send("玩家一 " + player1.getName());
                break;
            } catch (Exception ignored) {
                //don't need to do anything here
                //the loop just restart
            }
        }
        while(true) {
            outputMethod.send("玩家二，選擇你的角色");
            try {
                int id = inputMethod.getNumber();
                player2 = (Character)characterConstructors[id-1].newInstance();
                characterConstructors[id - 1] = null;
                outputMethod.send("玩家二 " + player2.getName());
                break;
            } catch (Exception e) {
                //don't need to do anything here
                //the loop just restart
            }
        }
        if (new Random().nextBoolean()) { //random select between true or false
            Character tmp = player1;
            player1 = player2;
            player2 = tmp;
        }

        outputMethod.send(player1.getName() + "先攻");

        Client client1 = new StandAloneClient(player1);
        Client client2 = new StandAloneClient(player2);
        GameCenter center = new TwoPlayerGameCenter(client1, client2);
        center.begin();
    }
}
