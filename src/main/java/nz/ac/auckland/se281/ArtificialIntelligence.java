package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** Abstract class serving as a blueprint for different types of AI players. */
public abstract class ArtificialIntelligence {
  protected String name = "HAL-9000";
  protected Choice choice;
  protected GameStrategy gameStrat;
  private int currentHand;

  /**
   * Create new instance of an AI player. This constructor can only be used alongside a constructor
   * in a non-abstract child class.
   *
   * @param choice The player's bet between ODD and EVEN.
   */
  public ArtificialIntelligence(Choice choice) {
    this.choice = choice;
  }

  /**
   * Update the AI's current strategy in an attempt to increase its chances of winning.
   *
   * @param gameStrat The next strategy the AI will implement.
   */
  public void setStrategy(GameStrategy gameStrat) {
    this.gameStrat = gameStrat;
  }

  /**
   * Displays AI's input (number of fingers).
   *
   * @param round The number of the current round in the active game.
   * @param history An array containing the frequency of the human player choosing even and odd
   *     numbers.
   * @param wonLastGame Whether the AI won the most recent game.
   */
  public void play(int round, int[] history, boolean wonLastGame) {
    currentHand = gameStrat.playNumber(history, choice);
    MessageCli.PRINT_INFO_HAND.printMessage(name, currentHand + "");
  }

  /**
   * Gets AI's input (number of fingers).
   *
   * @return Number of fingers AI puts forth.
   */
  public int getCurrentHand() {
    return currentHand;
  }

  /**
   * Gets AI's name (invariably HAL-9000).
   *
   * @return Name of AI.
   */
  public String getName() {
    return name;
  }
}
