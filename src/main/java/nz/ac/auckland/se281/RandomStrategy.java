package nz.ac.auckland.se281;

public class RandomStrategy implements GameStrategy {

  @Override
  public String playNumber() {
    return Utils.getRandomNumberRange(0, 5) + "";
  }
}
