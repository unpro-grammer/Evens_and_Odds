package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardArtificialIntelligence extends ArtificialIntelligence {

  GameStrategy randomStrat = new RandomStrategy();
  GameStrategy topStrat = new TopStrategy();

  public HardArtificialIntelligence(Choice choice) {
    super(choice);
    setStrategy(randomStrat);
  }

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
