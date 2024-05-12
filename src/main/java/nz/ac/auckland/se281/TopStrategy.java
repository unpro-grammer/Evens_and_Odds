package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements GameStrategy {

  @Override
  public int playNumber(int[] history, Choice choice) {
    switch (choice) {
        // player wagers even
      case EVEN:
        if (history[0] != history[1]) {
          return (history[0] > history[1]) // player favours evens?
              ? Utils.getRandomOddNumber()
              : Utils.getRandomEvenNumber();
        }
        return Utils.getRandomNumberRange(0, 5);

        // player wagers odd
      case ODD:
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
