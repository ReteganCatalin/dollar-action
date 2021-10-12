package player;

import java.util.List;

import static player.Choice.COOPERATE;
import static player.Strategy.CUSTOM;

public class CustomPlayer extends Player {

  @Override
  public Choice play() {
    final List<Choice> allPreviousOpponentChoices = getAllPreviousOpponentChoices();
    final Choice lastOpponentChoice = getLastOpponentChoice();
    final List<Choice> last2OpponentChoices = getLastNOpponentChoices(2);
    final boolean firstChoice = isFirstChoice();
    final boolean last4ChoicesAreCooperate = lastNChoicesAre(4, COOPERATE);

    // todo: implement me
    return Choice.random();
  }

  @Override
  public Strategy getStrategy() {
    return CUSTOM;
  }
}
