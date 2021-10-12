package player.actual;

import player.Choice;
import player.Player;
import player.Strategy;

import java.util.List;

import static player.Choice.BETRAY;
import static player.Choice.SILENT;
import static player.Strategy.NASH_NON_EQ;

public class NashNonEquilibriumPlayer extends Player {
  @Override
  public Choice play() {
    final List<Choice> allPreviousOpponentChoices = getAllPreviousOpponentChoices();
    final Choice lastOpponentChoice = getLastOpponentChoice();
    final List<Choice> last2OpponentChoices = getLastNOpponentChoices(2);
    final boolean firstChoice = isFirstChoice();
    final boolean last4ChoicesAreSilent = lastNChoicesAre(4, SILENT);

    if (firstChoice) {
      return SILENT;
    }

    if (lastNChoicesAre(2, SILENT)) {
      return BETRAY;
    } else if (lastNChoicesAre(10, BETRAY)){
      return BETRAY;
    } else {
      return SILENT;
    }
  }


  @Override
  public Strategy getStrategy() {
    return NASH_NON_EQ;
  }
}
