package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class RandomStrategy implements GameStrategy {

  @Override
  public int playNumber(int[] history, Choice choice) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
