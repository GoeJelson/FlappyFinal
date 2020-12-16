package edu.lewisu.josephknelson;


import com.badlogic.gdx.graphics.Texture;

public class Pipe {
    int TX, TY, BX, BY;

    Texture txtrUp = new Texture("./sprites/pipeUp.png");
    Texture txtrDown = new Texture("./sprites/pipeDown.png");

    public int getTX() {
        return this.TX;
    }

    public void setTX(int TX) {
        this.TX += TX;
    }

    public int getTY() {
        return this.TY;
    }

    public void setTY(int TY) {
        this.TY = TY;
    }

    public int getBX() {
        return this.BX;
    }

    public void setBX(int BX) {
        this.BX += BX;
    }

    public int getBY() {
        return this.BY;
    }

    public void setBY(int BY) {
        this.BY = BY;
        setTY(BY + txtrUp.getHeight() + 80);
    }

    public Texture getTextureU(){
        return this.txtrUp;
    }

    public Texture getTextureD(){
        return this.txtrDown;
    }

    public void slide(){
        setBX(-2);
        setTX(-2);
    }

    public Pipe(int BY){
        this.BX = 300;
        this.BY = BY;
        this.TX = 300;
        this.TY = BY + txtrUp.getHeight() + 80;
    }
}