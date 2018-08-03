package com.jpatel.golf;

import java.util.ArrayList;
import java.util.List;

public class GameInstance {

  public Deck drawDeck = new Deck();
  public Deck discardDeck = new Deck();
  public List<Player> players = new ArrayList<Player>();
  private int currentPlayerIndex = 0;
  
  private int numHiddenCards = 3;
  private int numVisibleCards = 3;
  private float screenWidth = 800;
  private float screenHeight = 480;
  
  public GameInstance(List<PlayerConfig> playerConfigs) {
    drawDeck.init(); //set up 52 cards shuffled
    
    //determine player dimensions
    int playerWidth = Card.WIDTH * Math.max(numHiddenCards, numVisibleCards);
    int playerHeight = Card.HEIGHT * 2;
    
    for (PlayerConfig config : playerConfigs) {
      players.add(config.createPlayer(this, playerWidth, playerHeight));
    }
    
    //position all of the players
    //int x = 
  }
  
  private void dealCards() {
    //deal cards to players
    for (Player player : players) {
      //give each player hidden cards and visible cards
      for (int i = 0; i < numHiddenCards; i++) {
        player.hiddenCards.add(drawDeck.drawCard());
      }
      for (int j = 0; j < numVisibleCards; j++) {
        player.visibleCards.add(drawDeck.drawCard());
      }
    }
  }
  
  public void playGame() {
    dealCards();
    
    //take current player and have them play
    players.get(currentPlayerIndex).play();
  }
  
  //a player calls this when ending their turn
  //if stopGame is true, then the current player just called it
  //returns the winning player
  public List<Player> nextPlayer(boolean stopGame) {
    if (stopGame) {
      return determineWinner();
    }
    currentPlayerIndex++;
    if (currentPlayerIndex >= players.size()) {
      currentPlayerIndex = 0;
    }
    players.get(currentPlayerIndex).play();
    return null;
  }

  private List<Player> determineWinner() {
    //the player who called it is players.get(currentPlayerIndex)
    
    List<Player> winners = new ArrayList<Player>();
    
    Player caller = players.get(currentPlayerIndex);
    int minScore = caller.getScore();
    boolean callerWon = true;
    for (Player player : players) {
      if (player == caller) continue;
      int tmpScore = player.getScore();
      if (tmpScore <= minScore) {
        callerWon = false;
        if (tmpScore == minScore) {
          winners.add(player);
        } else {
          minScore = player.getScore();
          winners.clear();
          winners.add(player);
        }
      }
    }
    
    if (callerWon) {
      winners.add(caller);
    }
    
    return winners;
  }

  public float getWidth() {
    return screenWidth;
  }

  public float getHeight() {
    return screenHeight;
  }
}
