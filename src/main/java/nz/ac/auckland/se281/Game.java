package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int round;
  private String player;
  protected Difficulty difficulty;
  protected Choice choice;
  private ArtificialIntelligence aiPlayer = null;
  private boolean AIWonLastGame = false;
  private int humanWins;
  private int aiWins;

  // records frequency of even nums being chosen in index 0, and odd in index 1
  int[] history;

  /**
   * Registers the desired difficulty level and choice (odd or even), and then greets the user based
   * on the name they give.
   *
   * @param difficulty Difficulty level between easy, medium, and hard.
   * @param choice Player's wager between odd and even.
   * @param options Array containing user's name.
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.round = 0;
    this.player = options[0];
    this.difficulty = difficulty;
    this.choice = choice;
    this.aiPlayer = ArtificialIntelligenceFactory.createAI(difficulty, choice);
    this.AIWonLastGame = false;
    this.history = new int[] {0, 0};
    this.humanWins = 0;
    this.aiWins = 0;
  }

  /**
   * Checks the input is between 0 and 5 (inclusive), and therefore valid.
   *
   * @param num The user's provided input.
   * @return Boolean value for whether the input is valid.
   */
  private boolean isValidInput(String num) {

    if (!Utils.isInteger(num)) {
      return false;
    }

    int number = Integer.parseInt(num);

    return (number <= 5 && number >= 0) ? true : false;
  }

  /**
   * Checks whether the human player or the AI won the round.
   *
   * @param playerHand The number of fingers the human chose.
   * @param ai The number of fingers the AI chose.
   * @param choice The human's bet between ODD and EVEN.
   */
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
    if (winner == player) {
      AIWonLastGame = false;
      humanWins++;
    } else {
      AIWonLastGame = true;
      aiWins++;
    }

    MessageCli.PRINT_OUTCOME_ROUND.printMessage(sum + "", oddOrEven, winner);
  }

  /** Start a new round given a game is active. */
  public void play() {
    if (!gameActive()) {
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

  /**
   * Checks whether there is a currently active game by seeing if an AI opponent exists.
   *
   * @return Boolean value for whether there is an active game.
   */
  private boolean gameActive() {
    if (aiPlayer == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return false;
    }
    return true;
  }

  /**
   * Ends current game by resetting AI player to null if there is an active game. Display stats and
   * overall winner.
   */
  public void endGame() {
    if (!gameActive()) {
      return;
    }
    showStats();
    if (humanWins != aiWins) {
      String overallWinner = humanWins > aiWins ? player : aiPlayer.getName();
      MessageCli.PRINT_END_GAME.printMessage(overallWinner);
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    // reset game (no currently active game)
    aiPlayer = null;
  }

  /** Display current wins/losses of each player in an active game. */
  public void showStats() {
    if (!gameActive()) {
      return;
    }

    MessageCli.PRINT_PLAYER_WINS.printMessage(player, humanWins + "", aiWins + "");
    MessageCli.PRINT_PLAYER_WINS.printMessage(aiPlayer.getName(), aiWins + "", humanWins + "");
  }
}
