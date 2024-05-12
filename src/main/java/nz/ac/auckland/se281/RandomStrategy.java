package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class RandomStrategy implements GameStrategy {

  int aiHand;

  @Override
  public int playNumber(int[] history, Choice choice) {
    aiHand = Utils.getRandomNumberRange(0, 5);
    return aiHand;
  }
}
