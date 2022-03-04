package player.actual;

import player.Player;
import player.Strategy;

import static player.Strategy.GIT_GOOD;

public class GitGoodPlayer extends Player {
  @Override
  public float play(float bid) {
      return bid+1f;
  }

  @Override
  public Strategy getStrategy() {
    return GIT_GOOD;
  }
}
