package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  int round = 0;
  String player = "";
  Difficulty difficulty;
  Choice choice;

  /**
   * Registers the desired difficulty level and choice (odd or even), and then greets the user based
   * on the name they give.
   *
   * @param difficulty difficulty level between easy, medium, and hard
   * @param choice player's wager between odd and even
   * @param options array containing user's name
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.player = options[0];
    this.difficulty = difficulty;
    this.choice = choice;
  }

  private boolean isValidInput(String num) {

    if (!Utils.isInteger(num)) {
      return false;
    }

    int number = Integer.parseInt(num);

    return (number <= 5 && number >= 0) ? true : false;
  }

  private void getWinner(int playerHand, ArtificialIntelligence ai, Choice choice) {

    int aiHand = ai.getCurrentHand();
    int sum = playerHand + aiHand;
    String winner;
    String oddOrEven;

    switch (choice) {
      case ODD:
        winner = Utils.isOdd(sum) ? player : ai.getName();
      case EVEN:
        winner = Utils.isEven(sum) ? player : ai.getName();
      default:
        winner = player;
    }

    oddOrEven = Utils.isEven(sum) ? "EVEN" : "ODD";

    MessageCli.PRINT_OUTCOME_ROUND.printMessage(sum + "", oddOrEven, winner);
  }

  public void play() {
    round++;
    MessageCli.START_ROUND.printMessage(round + "");
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    while (!isValidInput(input)) {
      MessageCli.INVALID_INPUT.printMessage();
      input = Utils.scanner.nextLine();
    }
    MessageCli.PRINT_INFO_HAND.printMessage(player, input);

    ArtificialIntelligence aiPlayer = AIFactory.createAI(difficulty, choice);
    aiPlayer.play();
    getWinner(Integer.parseInt(input), aiPlayer, choice);
  }

  public void endGame() {}

  public void showStats() {}
}
