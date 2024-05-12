package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** Game strategy that operates based on previous user behavioural patterns. */
public class TopStrategy implements GameStrategy {

  /** Generate a valid number based on human player's patterns. */
  @Override
  public int playNumber(int[] history, Choice choice) {
    switch (choice) {
      case EVEN:
        // player wagers even
        if (history[0] != history[1]) {
          return (history[0] > history[1]) // player favours evens?
              ? Utils.getRandomOddNumber()
              : Utils.getRandomEvenNumber();
        }
        return Utils.getRandomNumberRange(0, 5);

      case ODD:
        // player wagers odd
        if (history[0] != history[1]) {
          return (history[0] < history[1]) // player favours odds?
              ? Utils.getRandomOddNumber()
              : Utils.getRandomEvenNumber();
        }
        return Utils.getRandomNumberRange(0, 5);
      default:
        return 0;
    }
  }
}
