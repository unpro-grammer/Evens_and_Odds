package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

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
    setStrategy(randomStrat);
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
