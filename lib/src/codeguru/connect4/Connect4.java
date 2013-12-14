package codeguru.connect4;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;

public class Connect4 implements ApplicationListener {
	private Mesh mesh = null;
	
	public void create() {
		if (this.mesh == null) {
			this.mesh = new Mesh(true, 3, 3, new VertexAttribute(Usage.Position, 3,
					"a_position"));

			this.mesh.setVertices(new float[] { -0.5f, -0.5f, 0, 0.5f, -0.5f, 0, 0,
					0.5f, 0 });
			this.mesh.setIndices(new short[] { 0, 1, 2 });
		}
	}

	public void render() {
		Gdx.gl.glClearColor(0.0f, 0.0f, 1.0f, 1.0f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		mesh.render(GL10.GL_TRIANGLES, 0, 3);
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