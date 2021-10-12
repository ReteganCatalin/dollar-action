package player.computer;

import player.Choice;
import player.Player;
import player.Strategy;

import static player.Choice.BETRAY;
import static player.Strategy.ALWAYS_BETRAY;

public class AlwaysBetrayPlayer extends Player {
  @Override
  public Choice play() {
    return BETRAY;
  }

  @Override
  public Strategy getStrategy() {
    return ALWAYS_BETRAY;
  }
}
