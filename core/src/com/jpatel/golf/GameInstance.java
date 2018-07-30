package com.jpatel.golf;

import java.util.ArrayList;
import java.util.List;

public class GameInstance {

  public Deck drawDeck = new Deck();
  public Deck discardDeck = new Deck();
  private List<Player> players = new ArrayList<Player>();
  private int currentPlayerIndex = 0;
  
  public GameInstance(List<PlayerConfig> playerConfigs) {
    drawDeck.init(); //set up 52 cards shuffled
    
    for (PlayerConfig config : playerConfigs) {
      players.add(config.createPlayer(this));
    }
  }
  
  //returns the winning player
  public Player playGame() {
    //deal cards to players
    
    //take current player and have them play
    players.get(currentPlayerIndex).play();
    
    return null; //return winner
  }
}
