package player.actual;
import player.Choice;
import player.Player;
import player.Strategy;

import java.util.List;

import static player.Choice.BETRAY;
import static player.Choice.SILENT;
import static player.Strategy.ABC;

public class ABCPlayer extends Player {
  @Override
  public Choice play() {
    final List<Choice> allPreviousOpponentChoices = getAllPreviousOpponentChoices();
    final Choice lastOpponentChoice = getLastOpponentChoice();
    final List<Choice> last2OpponentChoices = getLastNOpponentChoices(2);
    final boolean firstChoice = isFirstChoice();
    final boolean last4ChoicesAreSilent = lastNChoicesAre(4, SILENT);



    return strat();
  }

  private int roundNumber() {
    return getAllPreviousOpponentChoices().size();
  }

  private Choice copycatStrategy() {
    if (roundNumber() >= 199) {
      return BETRAY;
    }
    return isFirstChoice() ? SILENT : getLastOpponentChoice();
  }

  private Choice strat() {
    if (roundNumber() < 5) {
      return copycatStrategy();
    } else {
      long betrayCount = getAllPreviousOpponentChoices().stream().filter(Choice::betrays).count();
      if (betrayCount > 1) {
        return BETRAY;
      } else {
        return copycatStrategy();
      }
    }
  }

  private Choice cheatStrategy() {
    return BETRAY;
  }

  @Override
  public Strategy getStrategy() {
    return ABC;
  }
}
