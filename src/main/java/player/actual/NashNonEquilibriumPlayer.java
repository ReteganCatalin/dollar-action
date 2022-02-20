package player.actual;

import player.Player;
import player.Strategy;

import static player.Strategy.NASH_NON_EQ;

public class NashNonEquilibriumPlayer extends Player {
  @Override
  public float play(float currentBid) {
    return currentBid + 1f;
  }


  @Override
  public Strategy getStrategy() {
    return NASH_NON_EQ;
  }
}
