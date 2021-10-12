package player.actual;

import player.Choice;
import player.Player;
import player.Strategy;

import java.util.List;

import static player.Choice.BETRAY;
import static player.Choice.SILENT;
import static player.Strategy.THE_FAR_AWAYS;

public class TheFarAwaysPlayer extends Player {
  int roundNr = 0;

  @Override
  public Choice play() {
    roundNr++;
    final List<Choice> allPreviousOpponentChoices = getAllPreviousOpponentChoices();
    final Choice lastOpponentChoice = getLastOpponentChoice();
    final List<Choice> last2OpponentChoices = getLastNOpponentChoices(2);
    final boolean firstChoice = isFirstChoice();
    final boolean last4ChoicesAreSilent = lastNChoicesAre(4, SILENT);

    if (firstChoice) {
      return SILENT;
    }

    if (roundNr % 100 == 0) {
      return BETRAY;
    }

    if (lastNChoicesAre(2, SILENT)) {
      return SILENT;
    }

    if (lastNChoicesAre(2, BETRAY)) {
      return BETRAY;
    }

    return lastOpponentChoice;
  }

  @Override
  public Strategy getStrategy() {
    return THE_FAR_AWAYS;
  }
}
