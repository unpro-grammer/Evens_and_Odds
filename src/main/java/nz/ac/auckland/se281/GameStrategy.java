package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** Creation of interface for game strategies to implement and be defined as such. */
public interface GameStrategy {
  public int playNumber(int[] history, Choice choice);
}
