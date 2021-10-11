package player.computer;

import player.Choice;
import player.Player;
import player.Strategy;

import java.util.List;

import static player.Choice.BETRAY;
import static player.Choice.COOPERATE;
import static player.Strategy.TIT_FOR_TWO_TATS;

public class TitForTwoTatsPlayer extends Player {
  @Override
  public Choice play() {
    if (isFirstChoice()) {
      return COOPERATE;
    }
    final List<Choice> last2OpponentChoices = getLastNOpponentChoices(2);
    if (last2OpponentChoices.stream().allMatch(Choice::betrays)) {
      return BETRAY;
    }
    return COOPERATE;
  }

  @Override
  public Strategy getStrategy() {
    return TIT_FOR_TWO_TATS;
  }
}
