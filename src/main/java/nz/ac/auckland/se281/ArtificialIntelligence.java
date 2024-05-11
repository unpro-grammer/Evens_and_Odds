package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public abstract class ArtificialIntelligence {
  private Difficulty difficulty;
  private GameStrategy gamestrat;

  public ArtificialIntelligence(Difficulty difficulty) {
    this.difficulty = difficulty;
  }

  public abstract void play();
}
