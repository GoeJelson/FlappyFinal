package edu.lewisu.josephknelson;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;
import java.util.Random;
import com.badlogic.gdx.audio.Music;



public class FlappyFinal extends ApplicationAdapter {
	SpriteBatch batch;
	OrthographicCamera cam;
	float WIDTH, HEIGHT;
	Bird charlie;
	Pipe middle;
	Random random = new Random();
	int score, position;
	private Music bgMusic;


	
	public void collisionHandler(Bird bird, Pipe pipe) {
		if (((bird.getXCoord()+bird.getTexture().getWidth()) >= (pipe.getTX())) && ((bird.getXCoord()) <= (pipe.getBX()+pipe.getTextureU().getWidth())) ) {
			if ((bird.getYCoord()+bird.getTexture().getHeight()) >= (pipe.getTY())) {
				//move screen to game over 
			} else if ((bird.getYCoord()) <= (pipe.getBY()+pipe.getTextureU().getHeight())) {
				//move screen to game over
			} else {
				score++;
			}
		} 
	}

	// if the far right edge of the pipe goes past the screen edge it will reset the pipe
	public void wallHandler(Pipe pipe) {
		if (pipe.getTX()+pipe.getTextureU().getWidth() <= 0) {
			//moves the pipe back to the main position
			pipe.setBX(300);
			pipe.setTX(300);
			// gives the pipe a new height on the next pass
			pipe.setBY(random.nextInt(100) * -1);
		}
	}

	@Override
	public void create () {
		bgMusic = Gdx.audio.newMusic(Gdx.files.internal("./music/newer-wave-by-kevin-macleod-from-filmmusic-io.mp3"));
		bgMusic.setLooping(true);
		batch = new SpriteBatch();
		score = 0;
		WIDTH = 250;
		HEIGHT = 250;
		charlie = new Bird(250/2, 250/2);
		middle = new Pipe(-50);
		cam = new OrthographicCamera(WIDTH, HEIGHT);
		cam.translate(WIDTH/2, HEIGHT/2);
		cam.update();
		batch.setProjectionMatrix(cam.combined);
	}

	@Override
	public void render () {
		bgMusic.setVolume(0.006f);
		bgMusic.play();
		Gdx.gl.glClearColor(0, 162/255f, 232/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//moves the pipe 
		middle.slide();
		//allows for the keyboard to be listened to and charlie to move
		charlie.handle();
		//gravity is set so that charlie will always be pulled toward the ground
		charlie.gravity();
		//makes checks between the pipe and the bird to see if the game will end
		collisionHandler(charlie, middle);
		//checks the pipe to see if it runs off the edge of the screen
		wallHandler(middle);
		//these are the textures for the game these are what my objects update to display the objects to the player
		batch.begin();
		batch.draw(charlie.getTexture(), charlie.getXCoord(), charlie.getYCoord());
		batch.draw(middle.getTextureU(), middle.getBX(), middle.getBY());
		batch.draw(middle.getTextureD(), middle.getTX(), middle.getTY());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		bgMusic.dispose();
	}
}
