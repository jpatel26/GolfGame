package com.jpatel.golf;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Golf extends Game {
  
  public SpriteBatch batch;
  public BitmapFont font;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		
		//Use LibGDX's default Arial font.
    font = new BitmapFont();
		
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
	  super.render();
	  /*
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.draw(img, 10, 10, 50, 50);
		batch.end();
		*/
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}
}
