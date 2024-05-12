package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumAI extends ArtificialIntelligence {

  public MediumAI(Choice choice) {
    super(choice);
    setStrategy(new RandomStrategy());
  }

  @Override
  public void play(int round, int[] history) {
    super.play(round, history);
  }
}
