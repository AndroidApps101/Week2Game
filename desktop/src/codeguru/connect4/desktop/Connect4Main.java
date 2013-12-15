package codeguru.connect4.desktop;

import codeguru.connect4.Connect4;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class Connect4Main {
    public static void main(String[] args) {
        new LwjglApplication(new Connect4(), "Connect4", 640, 480, false);
    }
}
