package player.actual;

import player.Choice;
import player.Player;
import player.Strategy;

import java.util.List;

import static player.Choice.BETRAY;
import static player.Choice.SILENT;
import static player.Strategy.EMANUEII;

public class EmanueiiPlayer extends Player {
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
    if (lastNChoicesAre(1, SILENT) && computeScore() == BETRAY){
      return BETRAY;
    }
    else if (lastNChoicesAre(2, SILENT)) {
      return BETRAY;
    } else if (computeScore() == BETRAY && lastNChoicesAre(2, BETRAY)){
      return BETRAY;
    } else {
      return SILENT;
    }
  }

  @Override
  public Strategy getStrategy() {
    return EMANUEII;
  }

  private Choice computeScore() {
    int betray = 0;
    int silent = 0;
    final List<Choice> allPreviousOpponentChoices = getAllPreviousOpponentChoices();
    for (Choice c : allPreviousOpponentChoices) {
      if (c.isSilent()) {
        silent = silent + 1;
      } else {
        betray = betray + 1;
      }
    }

    return silent > betray ? SILENT : BETRAY;
  }
}
