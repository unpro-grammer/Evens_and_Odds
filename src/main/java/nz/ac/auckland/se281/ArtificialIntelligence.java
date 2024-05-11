package nz.ac.auckland.se281;

public abstract class ArtificialIntelligence {
  private String difficulty;
  private GameStrategy gamestrat;

  public ArtificialIntelligence(String difficulty) {
    this.difficulty = difficulty;
  }

  public abstract void play();
}
