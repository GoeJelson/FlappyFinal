package edu.lewisu.josephknelson;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;


public class FlappyFinal extends ApplicationAdapter {
	SpriteBatch batch;
	OrthographicCamera cam;
	float WIDTH, HEIGHT;
	Bird charlie;
	Pipe middle;

	public void collisionHandler(Bird bird, Pipe pipe) {
		// if(((bird.getXCoord()+bird.getTexture().getWidth()) >= (pipe.getTX())) && ((bird.getYCoord()+bird.getTexture().getHeight()) >= (pipe.getTY()))) { 
		// 	//System.out.print("HI my name is Aaron");
		// 	charlie.setXCoord(pipe.getTX()-bird.getTexture().getWidth());
		// } else if (((bird.getXCoord()+bird.getTexture().getWidth() >= (pipe.getTX())) && ((bird.getYCoord()) <= (pipe.getBY() + pipe.getTextureU().getHeight())))) {
		// 	charlie.setXCoord(pipe.getTX()-bird.getTexture().getWidth());
		// } else if ((bird.getYCoord()) <= (pipe.getBY()+pipe.getTextureU().getHeight())) {
		// 	charlie.setYCoord((pipe.getBY()+pipe.getTextureU().getHeight()));
		// } else if () {

		// }
		if (((bird.getXCoord()+bird.getTexture().getWidth()) >= (pipe.getTX())) && ((bird.getXCoord()) <= (pipe.getBX()+pipe.getTextureU().getWidth())) ) {
			if ((bird.getYCoord()+bird.getTexture().getHeight()) >= (pipe.getTY())) {
				charlie.setYCoord(pipe.getTY()-bird.getTexture().getHeight());
			} else if ((bird.getYCoord()) <= (pipe.getBY()+pipe.getTextureU().getHeight())) {
				charlie.setYCoord(pipe.getBY()+pipe.getTextureU().getHeight());
			}
		}
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		WIDTH = 500;
		HEIGHT = 500;
		charlie = new Bird(500/2, 500/2);
		middle = new Pipe(-50);
		cam = new OrthographicCamera(WIDTH, HEIGHT);
		cam.translate(WIDTH/2, HEIGHT/2);
		cam.update();
		batch.setProjectionMatrix(cam.combined);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		middle.slide();
		charlie.handle();
		charlie.gravity();
		collisionHandler(charlie, middle);
		batch.begin();
		batch.draw(middle.getTextureU(), middle.getBX(), middle.getBY());
		batch.draw(middle.getTextureD(), middle.getTX(), middle.getTY());
		batch.draw(charlie.getTexture(), charlie.getXCoord(), charlie.getYCoord());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
