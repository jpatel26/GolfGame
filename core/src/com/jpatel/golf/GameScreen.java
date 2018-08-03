package com.jpatel.golf;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen implements Screen {

  private final Golf game;
  
  private OrthographicCamera camera;
  
  private GameInstance gameInstance;
  
  public GameScreen(Golf game, GameInstance gameInstance) {
    this.game = game;
    
    camera = new OrthographicCamera();

    camera.setToOrtho(false, gameInstance.getWidth(), gameInstance.getHeight());
    
    this.gameInstance = gameInstance;
    gameInstance.playGame();
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
    game.font.draw(game.batch, "GAME SCREEN", 100, 150);
    //draw players (each player draws their own cards)
    for (Player player : gameInstance.players) {
      player.draw(game);
    }
    game.batch.end();
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
