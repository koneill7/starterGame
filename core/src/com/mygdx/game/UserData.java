package com.mygdx.game;

public abstract class UserData {
    protected float width;
    protected float height;

    public UserData(float width, float height){
        this.width = width;
        this.height = height;
    }
    public float getWidth(){
        return width;
    }
    public float getHeight(){
        return height;
    }
    public void setWidth(){
        this.width = width;
    }
    public void setHeight(){
        this.height = height;
    }
}
