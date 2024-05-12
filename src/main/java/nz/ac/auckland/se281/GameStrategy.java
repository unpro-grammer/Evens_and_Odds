package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public interface GameStrategy {
  public int playNumber(int[] history, Choice choice);
}
