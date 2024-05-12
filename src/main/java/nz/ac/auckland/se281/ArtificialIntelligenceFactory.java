package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class ArtificialIntelligenceFactory {
  /**
   * Create a new instance of an AI player at the start of a new game based on the difficulty level
   * the human player has chosen.
   *
   * @param difficulty The difficulty level from a choice of hard, medium, easy.
   * @param choice The player's wager between EVEN and ODD.
   * @return The newly created AI player of a given difficulty.
   */
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
