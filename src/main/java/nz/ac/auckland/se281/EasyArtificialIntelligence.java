package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** The Easy AI player only uses the random strategy. */
public class EasyArtificialIntelligence extends ArtificialIntelligence {

  /**
   * Constructor for easy level AI.
   *
   * @param choice The player's bet between ODD and EVEN.
   */
  public EasyArtificialIntelligence(Choice choice) {
    super(choice);
    gameStrat = new RandomStrategy();
  }
}
