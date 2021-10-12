package player.actual;

import player.Choice;
import player.Player;
import player.Strategy;

import java.util.HashMap;
import java.util.List;

import static player.Choice.BETRAY;
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

    if (!firstChoice) {
      return getMostFrequentChoice(allPreviousOpponentChoices);
    }

    return Choice.random();
  }

  private Choice getMostFrequentChoice(List<Choice> allPreviousOpponentChoices) {
    HashMap<Choice, Integer> map = new HashMap<>();
    map.put(SILENT, 0);
    map.put(BETRAY, 0);
    allPreviousOpponentChoices
        .forEach(choice -> map.put(choice, map.get(choice) + 1));
    if(map.get(BETRAY) > map.get(SILENT)){
      return SILENT;
    }
    return BETRAY;
  }


  @Override
  public Strategy getStrategy() {
    return GIT_GOOD;
  }
}
