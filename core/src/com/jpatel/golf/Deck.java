package com.jpatel.golf;

import java.util.ArrayList;

public class Deck {

  //top of deck is the right side of the list
  private ArrayList<Card> cards = new ArrayList<Card>(); //these are the cards left in our deck
  
  //create empty deck
  public Deck() {
  }
  
  public void init() {
    //initialize standard deck of 52 cards (shuffled)
    for (int suit = 0; suit < 4; suit++) {
      for (int number = 1; number <= 13; number++) {
        cards.add(new Card(number));
      }
    }
    
    //now shuffle (Fisher-Yates)
    int j;
    Card tmp;
    for (int i = cards.size() - 1; i >= 0; i--) {
      j = (int) Math.floor(Math.random() * (i + 1));
      tmp = cards.get(i);
      cards.set(i, cards.get(j));
      cards.set(j, tmp);
    }
  }
  
  public Card drawCard() {
    return cards.remove(cards.size() - 1);
  }
  
  public void addCard(Card card) {
    cards.add(card);
  }
}
