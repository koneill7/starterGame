package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class Enemy {
    Body body;
    World newWorld;
    int health = 100;
    public Enemy(){
        createBox(20f,30f); //what to set this to?
    }
    private void createBox(float x, float y){
        BodyDef bodyDef = new BodyDef();
        FixtureDef fixtureDef = new FixtureDef();

        bodyDef.fixedRotation = true;
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x,y);
        //
        fixtureDef.density = 1.0f;
        body = newWorld.createBody(bodyDef);
        body.createFixture(fixtureDef).setUserData(this);
    }
    public void attack(Player player){
        player.injured();
    }
    public void injured(int damage){
        health  -= damage;
    }
}
