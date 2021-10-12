package player.actual;

import player.Choice;
import player.Player;
import player.Strategy;

import java.util.List;

import static player.Choice.BETRAY;
import static player.Choice.SILENT;
import static player.Strategy.PRIZONIERII_DIN_ALCATRAZ;

public class PrizonieriiDinAlcatrazPlayer extends Player {
  @Override
  public Choice play() {
    if (isFirstChoice()) {
      return BETRAY;
    }

    List<Choice> allPreviousOpponentChoices = getAllPreviousOpponentChoices();
    long silentCount = allPreviousOpponentChoices.stream().filter(Choice::isSilent).count();
    long betrayCount = allPreviousOpponentChoices.stream().filter(Choice::betrays).count();


    if (silentCount > betrayCount) {
      return SILENT;
    }

    return BETRAY;
  }

  @Override
  public Strategy getStrategy() {
    return PRIZONIERII_DIN_ALCATRAZ;
  }
}
