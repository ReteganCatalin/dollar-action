package player.actual;

import player.Choice;
import player.Player;
import player.Strategy;

import java.util.List;

import static player.Choice.SILENT;
import static player.Strategy.PRIZONIERII_DIN_ALCATRAZ;

public class PrizonieriiDinAlcatrazPlayer extends Player {
  @Override
  public Choice play() {
    return SILENT;
  }

  @Override
  public Strategy getStrategy() {
    return PRIZONIERII_DIN_ALCATRAZ;
  }
}
