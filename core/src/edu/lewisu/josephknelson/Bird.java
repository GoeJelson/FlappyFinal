package edu.lewisu.josephknelson;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Music;

public class Bird {
    int XCoord, YCoord; 
    Texture ch = new Texture("./sprites/ch.png");
    private Music flap = Gdx.audio.newMusic(Gdx.files.internal("./music/flap.mp3"));

    public int getXCoord() {
        return this.XCoord;
    }

    public void setXCoord(int XCoord) {
        this.XCoord = XCoord;
    }

	public int getYCoord() {
		return this.YCoord;
	}

	public void setYCoord(int YCoord) {
		this.YCoord = YCoord;
    }
    
    public Texture getTexture(){
        return this.ch;
    }

	public void gravity() {
        this.YCoord += -1;
    }

    public void handle(){
        if(Gdx.input.isKeyJustPressed(Keys.SPACE)) {
            this.YCoord += 10;
            flap.setVolume(1f);
            flap.play();
        }
    }

    public Bird(int XCoord, int YCoord){
        this.XCoord = XCoord;
        this.YCoord = YCoord;
    }
}