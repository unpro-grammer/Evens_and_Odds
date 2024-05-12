package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * The Medium AI begins with the random strategy and holds this for three rounds. It then switches
 * to the top strategy permanently.
 */
public class MediumArtificialIntelligence extends ArtificialIntelligence {

  /**
   * Constructor for medium level AI.
   *
   * @param choice The player's bet between ODD and EVEN.
   */
  public MediumArtificialIntelligence(Choice choice) {
    super(choice);
    setStrategy(new RandomStrategy());
  }

  /** Medium AI bot gives their input based on current strategy. */
  @Override
  public void play(int round, int[] history, boolean wonLastGame) {
    if (round == 4) {
      setStrategy(new TopStrategy());
    }
    super.play(round, history, wonLastGame);
  }
}
