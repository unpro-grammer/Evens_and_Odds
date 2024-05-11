package nz.ac.auckland.se281;

public class RandomStrategy implements GameStrategy {

  int aiHand;

  @Override
  public int playNumber() {
    aiHand = Utils.getRandomNumberRange(0, 5);
    return aiHand;
  }

  public int getAiHand() {
    return aiHand;
  }
}
