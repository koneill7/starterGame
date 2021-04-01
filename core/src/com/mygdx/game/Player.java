package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Player {
    Body body;
    World newWorld;
    public Player(World world){
        newWorld = world;
        createBox(10f, 20f);
    }
    private void createBox(float x, float y){
        BodyDef bodyDef = new BodyDef();
        PolygonShape polyShape = new PolygonShape();
        FixtureDef fixtureDef = new FixtureDef();

        bodyDef.fixedRotation = true;
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x,y);
        //
        fixtureDef.density = 1.0f;
        body = newWorld.createBody(bodyDef);
        body.createFixture(fixtureDef).setUserData(this);
    }
    public Body getBody(){
        return body;
    }
}
