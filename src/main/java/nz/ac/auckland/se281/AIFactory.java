package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AIFactory {
  public static ArtificialIntelligence createAI(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyAI(difficulty);
      default:
        return null;
    }
  }
}
