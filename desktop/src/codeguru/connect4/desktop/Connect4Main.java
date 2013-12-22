package codeguru.connect4.desktop;

import codeguru.connect4.Connect4;
import codeguru.connect4.Connect4.PlayerType;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class Connect4Main {
    public static void main(String[] args) {
        PlayerType[] types = new PlayerType[]{PlayerType.HUMAN, PlayerType.HUMAN};
        ApplicationListener app = new Connect4(types);
        new LwjglApplication(app, "Connect4", 640, 480, false);
    }
}
