package com.jpatel.golf;

import java.util.ArrayList;
import java.util.List;

public class Player {

  public final String name;
  public final GameInstance gameInstance;
  
  //these start as empty, game instance deals out cards at start
  private List<Card> hiddenCards = new ArrayList<Card>();
  private List<Card> visibleCards = new ArrayList<Card>();
  
  public Player(String name, GameInstance gameInstance) {
    this.name = name;
    this.gameInstance = gameInstance;
  }
  
  public boolean play() {
    //if calling it, then just return true
    //otherwise, draw a card
    //can discard this card, or swap with hidden/visible card
    return false;
  }
  
  private Card drawCard() {
    return gameInstance.drawDeck.drawCard();
  }
}
