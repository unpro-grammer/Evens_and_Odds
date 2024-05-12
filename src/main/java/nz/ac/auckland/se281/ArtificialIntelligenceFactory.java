package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class ArtificialIntelligenceFactory {
  public static ArtificialIntelligence createAI(Difficulty difficulty, Choice choice) {
    switch (difficulty) {
      case EASY:
        return new EasyArtificialIntelligence(choice);
      case MEDIUM:
        return new MediumArtificialIntelligence(choice);
      case HARD:
        return new HardArtificialIntelligence(choice);
      default:
        return null;
    }
  }
}
