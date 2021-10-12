package player.actual;

import player.Choice;
import player.Player;
import player.Strategy;

import java.util.List;

import static player.Choice.SILENT;
import static player.Strategy.GIT_GOOD;

public class GitGoodPlayer extends Player {
  @Override
  public Choice play() {
    final List<Choice> allPreviousOpponentChoices = getAllPreviousOpponentChoices();
    final Choice lastOpponentChoice = getLastOpponentChoice();
    final List<Choice> last2OpponentChoices = getLastNOpponentChoices(2);
    final boolean firstChoice = isFirstChoice();
    final boolean last4ChoicesAreSilent = lastNChoicesAre(4, SILENT);

    // todo: implement me
    return Choice.random();
  }

  @Override
  public Strategy getStrategy() {
    return GIT_GOOD;
  }
}
