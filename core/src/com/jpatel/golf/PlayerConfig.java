package com.jpatel.golf;

public class PlayerConfig {
  
  public static enum Type {
    HUMAN,
    AI
  }

  private final String name;
  private final Type type;
  
  public PlayerConfig(String name, Type type) {
    this.name = name;
    this.type = type;
  }
  
  public Player createPlayer(GameInstance gameInstance) {
    switch (type) {
      case HUMAN:
        return null; //new HumanPlayer(name, gameInstance)
      case AI:
        return null; //new AiPlayer(name, gameInstance)
      default:
        throw new IllegalArgumentException("This player type is not supported");
    }
  }
}
