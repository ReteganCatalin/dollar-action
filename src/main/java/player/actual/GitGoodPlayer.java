package player.actual;

import player.Choice;
import player.Player;
import player.Strategy;

import java.util.HashMap;
import java.util.List;

import static player.Choice.STOP;
import static player.Choice.BID;
import static player.Strategy.GIT_GOOD;

public class GitGoodPlayer extends Player {
  @Override
  public float play(float bid) {
    return bid + 1f;
  }

  @Override
  public Strategy getStrategy() {
    return GIT_GOOD;
  }
}
