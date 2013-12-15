package codeguru.connect4;

import com.badlogic.gdx.Gdx;

public class HumanPlayer implements Player {

    private Connect4 game = null;

    public HumanPlayer(Connect4 game) {
        this.game = game;
    }

    @Override
    public int move(Board b) {
        if (!Gdx.input.justTouched()) {
            int x = Gdx.input.getX();
            return x / game.getGridSize();
        }

        return -1;
    }

}
