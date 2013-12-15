package codeguru.connect4.desktop;

import codeguru.connect4.Board;
import codeguru.connect4.Connect4;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class Connect4Main {
    public static void main(String[] args) {
        new LwjglApplication(new Connect4(), "Connect4",
                (int) (2 * Connect4.RADIUS * Board.COL_COUNT),
                (int) (2 * Connect4.RADIUS * Board.ROW_COUNT), false);
    }
}
