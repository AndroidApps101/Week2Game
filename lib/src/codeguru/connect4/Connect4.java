package codeguru.connect4;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Connect4 implements ApplicationListener {
    private ShapeRenderer renderer = null;
    private Board board = null;
    private float radius = 0.0f;

    public void create() {
        if (this.renderer == null) {
            this.renderer = new ShapeRenderer();
        }

        if (this.board == null) {
            this.board = new Board();
        }
        
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        this.radius = Math.min((float) width / (float) Board.COL_COUNT,
                (float) height / Board.ROW_COUNT) / 2.0f;
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

                float x = (2 * col + 1) * this.radius;
                float y = (2 * row + 1) * this.radius;
                renderer.circle(x, y, this.radius);
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