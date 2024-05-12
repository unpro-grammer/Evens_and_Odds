package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public abstract class ArtificialIntelligence {
  protected String name = "HAL-9000";
  protected Choice choice;
  protected GameStrategy gameStrat;
  private int currentHand;
  protected int round;

  public ArtificialIntelligence(Choice choice) {
    this.choice = choice;
  }

  public void setStrategy(GameStrategy gameStrat) {
    this.gameStrat = gameStrat;
  }

  public void play(int round, int[] history, boolean wonLastGame) {
    currentHand = gameStrat.playNumber(history, choice);
    MessageCli.PRINT_INFO_HAND.printMessage(name, currentHand + "");
  }

  public int getCurrentHand() {
    return currentHand;
  }

  public String getName() {
    return name;
  }
}
