package player.computer;

import player.Choice;
import player.Player;
import player.Strategy;

import static player.Choice.SILENT;
import static player.Strategy.ALWAYS_SILENT;

public class AlwaysSilentPlayer extends Player {
  @Override
  public Choice play() {
    return SILENT;
  }

  @Override
  public Strategy getStrategy() {
    return ALWAYS_SILENT;
  }
}
