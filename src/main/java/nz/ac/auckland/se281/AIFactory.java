package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class AIFactory {
  public static ArtificialIntelligence createAI(Difficulty difficulty, Choice choice) {
    switch (difficulty) {
      case EASY:
        return new EasyAI(choice);
      case MEDIUM:
        return new MediumAI(choice);
      case HARD:
        return new HardAI(choice);
      default:
        return null;
    }
  }
}
