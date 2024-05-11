package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public abstract class ArtificialIntelligence {
  protected Choice choice;
  protected GameStrategy gameStrat;

  public ArtificialIntelligence(Choice choice) {
    this.choice = choice;
  }

  public void setStrategy(GameStrategy gameStrat) {
    this.gameStrat = gameStrat;
  }

  public abstract void play();
}
