package edu.lewisu.josephknelson;


import com.badlogic.gdx.graphics.Texture;

public class Pipe {
    int TX, TY, BX, BY;

    Texture txtrUp = new Texture("./badlogic.jpg");
    Texture txtrDown = new Texture("./badlogic.jpg");

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
    }

    public Texture getTextureU(){
        return this.txtrUp;
    }

    public Texture getTextureD(){
        return this.txtrDown;
    }

    public void slide(){
        setBX(-5);
        setTX(-5);
    }

    public Pipe(int BY){
        this.BX = 500;
        this.BY = BY;
        this.TX = 500;
        this.TY = txtrUp.getHeight() + 100;
    }
}