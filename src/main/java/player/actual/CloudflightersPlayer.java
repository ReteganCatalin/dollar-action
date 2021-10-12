package player.actual;

import player.Choice;
import player.Player;
import player.Strategy;

import java.util.List;

import static player.Choice.BETRAY;
import static player.Choice.SILENT;
import static player.Strategy.CLOUDFLIGHTERS;

public class CloudflightersPlayer extends Player {
  @Override
  public Choice play() {
    final List<Choice> allPreviousOpponentChoices = getAllPreviousOpponentChoices();
    final Choice lastOpponentChoice = getLastOpponentChoice();
    final List<Choice> last2OpponentChoices = getLastNOpponentChoices(2);
    final boolean firstChoice = isFirstChoice();
    final boolean last4ChoicesAreSilent = lastNChoicesAre(4, SILENT);

    if (allPreviousOpponentChoices.size() < 2) {
      return SILENT;
    }

    if (lastNChoicesAre(3, SILENT)) {
      return BETRAY;
    }

    int b = (int) allPreviousOpponentChoices.stream().filter(choice -> choice == BETRAY).count();
    int s = (int) allPreviousOpponentChoices.stream().filter(choice -> choice == SILENT).count();

    if (b > s) {
      return BETRAY;
    }
    return SILENT;
  }

  @Override
  public Strategy getStrategy() {
    return CLOUDFLIGHTERS;
  }
}
