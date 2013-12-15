package codeguru.connect4;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Connect4 implements ApplicationListener {
    public static float RADIUS = 25.0f;
    
    private ShapeRenderer renderer = null;
    private Board board = null;

    public void create() {
        if (this.renderer == null) {
            this.renderer = new ShapeRenderer();
        }

        if (this.board == null) {
            this.board = new Board();
        }
    }

    public void render() {
        Gdx.gl.glClearColor(0.0f, 0.0f, 1.0f, 1.0f);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        renderer.begin(ShapeType.Filled);
        for (int row = 0; row < Board.ROW_COUNT; ++row) {
            for (int col = 0; col < Board.COL_COUNT; ++col) {
                switch (this.board.getState(row, col)) {
                case EMPTY:
                    renderer.setColor(Color.WHITE);
                    break;
                case PLAYER1:
                    renderer.setColor(Color.RED);
                    break;
                case PLAYER2:
                    renderer.setColor(Color.RED);
                    break;
                }
                
                float x = 2 * col * RADIUS + RADIUS;
                float y = 2 * row * RADIUS + RADIUS;
                renderer.circle(x, y, RADIUS);
            }
        }
        renderer.end();
    }

    public void resize(int width, int height) {
    }

    public void pause() {
    }

    public void resume() {
    }

    public void dispose() {
    }
}