package player.computer;

import player.Choice;
import player.Player;
import player.Strategy;

import static player.Strategy.RANDOM;

public class CompletelyRandomPlayer extends Player {

  @Override
  public Choice play() {
    return Choice.random();
  }

  @Override
  public Strategy getStrategy() {
    return RANDOM;
  }
}
