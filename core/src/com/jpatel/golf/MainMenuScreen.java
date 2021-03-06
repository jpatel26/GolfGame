package com.jpatel.golf;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.jpatel.golf.PlayerConfig.Type;

public class MainMenuScreen implements Screen {
  
  private final Golf game;
  private OrthographicCamera camera;
  
  public MainMenuScreen(Golf game) {
    this.game = game;
    
    camera = new OrthographicCamera();
    camera.setToOrtho(false, 800, 480);
  }

  @Override
  public void show() {
    // TODO Auto-generated method stub

  }

  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(0, 0, 0.2f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    camera.update();
    game.batch.setProjectionMatrix(camera.combined);

    game.batch.begin();
    game.font.draw(game.batch, "Welcome to Drop!!! ", 100, 150);
    game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
    game.batch.end();

    if (Gdx.input.isTouched()) {
      //create playerConfigs
      List<PlayerConfig> configs = new ArrayList<PlayerConfig>();
      configs.add(new PlayerConfig("Jasmine", Type.HUMAN));
      configs.add(new PlayerConfig("John", Type.AI));
      //create new GameInstance(playerConfigs)
      game.setScreen(new GameScreen(game, new GameInstance(configs)));
      dispose();
    }
  }

  @Override
  public void resize(int width, int height) {
    // TODO Auto-generated method stub

  }

  @Override
  public void pause() {
    // TODO Auto-generated method stub

  }

  @Override
  public void resume() {
    // TODO Auto-generated method stub

  }

  @Override
  public void hide() {
    // TODO Auto-generated method stub

  }

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }

}
