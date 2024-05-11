package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class EasyAI extends ArtificialIntelligence {

  public EasyAI(Choice choice) {
    super(choice);
    gameStrat = new RandomStrategy();
  }
}
