package com.jpatel.golf;

import java.util.ArrayList;
import java.util.List;

public class Player {

  public final String name;
  public final GameInstance gameInstance;
  
  //these start as empty, game instance deals out cards at start
  public List<Card> hiddenCards = new ArrayList<Card>();
  public List<Card> visibleCards = new ArrayList<Card>();
  
  private int width;
  private int height;
  
  //upper left corner
  private int x = 0;
  private int y = 0;
  
  public Player(String name, GameInstance gameInstance, int width, int height) {
    this.name = name;
    this.gameInstance = gameInstance;
    this.width = width;
    this.height = height;
  }
  
  public void setX(int x) {
    this.x = x;
  }
  public void setY(int y) {
    this.y = y;
  }
  
  public void play() {
    //if calling it, then just return true
    //otherwise, draw a card
    //can discard this card, or swap with hidden/visible card
    
    Card card = drawCard();
    Card replaced = visibleCards.set(0, card);
    gameInstance.discardDeck.addCard(replaced);
    
    //gameInstance.nextPlayer(false);
  }
  
  public int getScore() {
    int sum = 0;
    for (Card card : hiddenCards) {
      sum += card.number;
    }
    for (Card card : visibleCards) {
      sum += card.number;
    }
    return sum;
  }
  
  private Card drawCard() {
    return gameInstance.drawDeck.drawCard();
  }

  //draw the player at predetermined coordinates
  public void draw(Golf game) {
    // TODO Auto-generated method stub
    
  }
}
