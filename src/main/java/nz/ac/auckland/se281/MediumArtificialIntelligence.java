package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumArtificialIntelligence extends ArtificialIntelligence {

  public MediumArtificialIntelligence(Choice choice) {
    super(choice);
    setStrategy(new RandomStrategy());
  }

  @Override
  public void play(int round, int[] history, boolean wonLastGame) {
    if (round == 4) {
      setStrategy(new TopStrategy());
    }
    super.play(round, history, wonLastGame);
  }
}
