package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  /**
   * Registers the desired difficulty level and choice (odd or even), and then greets the user based
   * on the name they give.
   *
   * @param difficulty
   * @param choice
   * @param options
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {}

  public void endGame() {}

  public void showStats() {}
}
