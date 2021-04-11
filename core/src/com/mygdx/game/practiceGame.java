package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;


public class practiceGame extends ApplicationAdapter {
	private static final float RESIZE = 2.0f;
	public static final float PPM = 32f;
	private static final float VELX = 0f;
	private static final float VELY = -10f; //adjust?
	private static final float TIME = 1/100f;//adjust?
	private static final int VEL_ITER = 6;
	private static final int POS_ITER = 2;
	SpriteBatch batch;
	Texture img;
	OrthographicCamera orthographicCamera;
	World world;
	Player player;
	Box2DDebugRenderer box2DDebugRenderer;

	@Override
	public void create () {
		//batch = new SpriteBatch();
		//img = new Texture("player.png");
		orthographicCamera = new OrthographicCamera();
		orthographicCamera.setToOrtho(false, Gdx.graphics.getWidth()/RESIZE, Gdx.graphics.getHeight()/RESIZE);
		world = new World(new Vector2(VELX, VELY ), false);
		System.out.println(world);
		player = new Player(world);
		box2DDebugRenderer = new Box2DDebugRenderer();
		makePlatform();
	}

	public Body makePlatform(){
		//use this method for now, try tiles for more complex map
		BodyDef platform = new BodyDef();
		platform.position.set(new Vector2(0.0F, 0.0F));
		platform.type = BodyDef.BodyType.StaticBody;
		Body platBody = world.createBody(platform);
		PolygonShape platShape = new PolygonShape();
		platShape.setAsBox(20.0F, 3.0F);
		platBody.createFixture(platShape, 0.25F);
		platBody.setUserData(new GroundUserData(40.0F, 6.0F));
		platShape.dispose();
		return platBody;
		
	}

	@Override
	public void render () {
		updateWorld();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		box2DDebugRenderer.render(world, orthographicCamera.combined.scl(PPM));
		/*batch.begin();
		batch.draw(img, 0, 0);
		batch.end();*/
	}

	@Override
	public void resize(int width, int height){
		orthographicCamera.setToOrtho(false, width / RESIZE, height / RESIZE);
	}

	private void updateCamera(){
		Vector3 position = orthographicCamera.position;
		position.x = player.getBody().getPosition().x = PPM;
		position.y = player.getBody().getPosition().y = PPM;
		orthographicCamera.position.set(position);
		orthographicCamera.update();
	}

	private void updateWorld(){
		world.step(TIME, VEL_ITER, POS_ITER);
		updateCamera();
	}

	@Override
	public void dispose () {
		//batch.dispose();
		//img.dispose();
	}
}
