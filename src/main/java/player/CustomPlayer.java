package player;

import java.util.List;

import static player.Strategy.CUSTOM;

public class CustomPlayer extends Player {

  @Override
  public Choice play() {
    final List<Choice> computerChoices = getOpponentChoices();
    final Choice lastComputerChoice = getLastOpponentChoice();
    final List<Choice> last2ComputerChoices = getLastNOpponentChoices(2);
    final boolean firstChoice = isFirstChoice();

    // todo: implement me
    return Choice.random();
  }

  @Override
  public Strategy getStrategy() {
    return CUSTOM;
  }
}
