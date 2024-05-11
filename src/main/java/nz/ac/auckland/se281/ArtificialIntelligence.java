package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public abstract class ArtificialIntelligence {
  protected String name = "HAL-9000";
  protected Choice choice;
  protected GameStrategy gameStrat;
  int currentHand;

  public ArtificialIntelligence(Choice choice) {
    this.choice = choice;
  }

  public void setStrategy(GameStrategy gameStrat) {
    this.gameStrat = gameStrat;
  }

  public void play() {
    currentHand = gameStrat.playNumber();
  }
}
