package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** Game strategy that randomly generates an input for the AI. */
public class RandomStrategy implements GameStrategy {

  /** Randomly generate a valid number. */
  @Override
  public int playNumber(int[] history, Choice choice) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
