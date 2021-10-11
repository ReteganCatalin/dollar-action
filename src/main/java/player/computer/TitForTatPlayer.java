package player.computer;

import player.Choice;
import player.Player;
import player.Strategy;

import static player.Choice.COOPERATE;
import static player.Strategy.TIT_FOR_TAT;

public class TitForTatPlayer extends Player {
  @Override
  public Choice play() {
    return getLastMoveOfOpponent();
  }

  @Override
  public Strategy getStrategy() {
    return TIT_FOR_TAT;
  }

  private Choice getLastMoveOfOpponent() {
    if (isFirstChoice()) {
      return COOPERATE;
    } else {
      return getLastOpponentChoice();
    }
  }
}
