package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  int round;
  String player;
  Difficulty difficulty;
  Choice choice;
  ArtificialIntelligence aiPlayer = null;
  boolean AIWonLastGame = false;
  private int humanWins;
  private int aiWins;
  private int ties;

  // records frequency of even nums being chosen in index 0, and odd in index 1
  int[] history;

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
    this.round = 0;
    this.player = options[0];
    this.difficulty = difficulty;
    this.choice = choice;
    this.aiPlayer = ArtificialIntelligenceFactory.createAI(difficulty, choice);
    this.history = new int[] {0, 0};
    this.humanWins = 0;
    this.aiWins = 0;
    this.ties = 0;
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
    history[playerHand % 2]++;

    switch (choice) {
      case ODD:
        winner = Utils.isOdd(sum) ? player : ai.getName();
        break;
      case EVEN:
        winner = Utils.isEven(sum) ? player : ai.getName();
        break;
      default:
        winner = player;
        break;
    }

    oddOrEven = Utils.isEven(sum) ? "EVEN" : "ODD";
    AIWonLastGame = (winner == player) ? false : true;

    MessageCli.PRINT_OUTCOME_ROUND.printMessage(sum + "", oddOrEven, winner);
  }

  public void play() {
    // check if new game has been started
    if (aiPlayer == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    round++;
    MessageCli.START_ROUND.printMessage(round + "");
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    while (!isValidInput(input)) {
      MessageCli.INVALID_INPUT.printMessage();
      input = Utils.scanner.nextLine();
    }
    MessageCli.PRINT_INFO_HAND.printMessage(player, input);

    aiPlayer.play(round, history, AIWonLastGame);
    getWinner(Integer.parseInt(input), aiPlayer, choice);
  }

  public void endGame() {}

  public void showStats() {}
}
