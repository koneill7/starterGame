package com.mygdx.game;

import android.os.Bundle;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.practiceGame;

//source: https://expertise.jetruby.com/creating-android-game-from-scratch-with-libgdx-box2d-45c381d84268

public class AndroidLauncher extends ApplicationAdapter {
	private static final float SCALE = 2.0f;
	private static final float PIXPM = 32f;

	private OrthographicCamera orthographicCamera;

	@Override
	public void create(){
		orthographicCamera = new OrthographicCamera();
		orthographicCamera.setToOrtho(false, Gdx.graphics.getWidth()/SCALE, Gdx.graphics.getHeight()/SCALE);
	}

	@Override
	public void render(){
		Gdx.gl.glClearColor(1f,1f,1f,1f);
		Gdx.gl.glClear(GL20.GL_DEPTH_BUFFER_BIT);
	}

	@Override
	public void resize(int width, int height){
		orthographicCamera.setToOrtho(false, width/SCALE, height/SCALE);
	}

	@Override
	public void dispose(){

	}
}
