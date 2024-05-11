package nz.ac.auckland.se281;

public class AIFactory {
  public static ArtificialIntelligence createAI(String difficulty) {
    switch (difficulty) {
      case "EASY":
        return new EasyAI(difficulty);
      default:
        return null;
    }
  }
}
