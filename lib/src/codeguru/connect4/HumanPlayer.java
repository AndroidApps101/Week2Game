package codeguru.connect4;

import com.badlogic.gdx.InputAdapter;

public class HumanPlayer extends InputAdapter implements Player {

    private Connect4 game = null;
    private int col = -1;

    public HumanPlayer(Connect4 game) {
        this.game = game;
    }

    @Override
    public int move(Board b) {
        if (this.col != -1) {
            System.out.println("move()");
            System.out.println("  col=" + this.col);

            int move = this.col;
            this.col = -1;
            return move;
        }

        return -1;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
        System.out.println("touchUp()");

        this.col = (x - this.game.getXMargin()) / this.game.getGridSize();

        System.out.println("  col=" + this.col);

        return true;
    }

}
