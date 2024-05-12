package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * The Hard AI uses the random strategy for he first three games. It then starts to adapt,
 * alternating between random and top strategies depending on whether the current one is getting
 * them a win.
 */
public class HardArtificialIntelligence extends ArtificialIntelligence {

  private GameStrategy randomStrat = new RandomStrategy();
  private GameStrategy topStrat = new TopStrategy();

  /**
   * Constructor for hard level AI.
   *
   * @param choice The player's bet between ODD and EVEN.
   */
  public HardArtificialIntelligence(Choice choice) {
    super(choice);
    setStrategy(new RandomStrategy());
  }

  /** Hard AI bot gives their input based on current strategy. */
  @Override
  public void play(int round, int[] history, boolean wonLastGame) {
    if (round >= 4) {
      if (!wonLastGame) {
        setStrategy(gameStrat instanceof RandomStrategy ? topStrat : randomStrat);
      }
    }
    super.play(round, history, wonLastGame);
  }
}
