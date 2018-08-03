package com.jpatel.golf;

public class Card {

  public static final int WIDTH = 50;
  public static final int HEIGHT = 50;
  
  public final int number; //no suit for now, just 4 of each number 1-13
  
  public Card(int number) {
    this.number = number;
  }
}
