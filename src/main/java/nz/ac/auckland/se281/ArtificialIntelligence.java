package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public abstract class ArtificialIntelligence {
  protected Choice choice;
  protected GameStrategy gamestrat;

  public ArtificialIntelligence(Choice choice) {
    this.choice = choice;
  }

  public abstract void play();
}
