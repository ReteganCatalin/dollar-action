package player.actual;

import player.Player;
import player.Strategy;

import java.util.List;

import static player.Strategy.CLOUDFLIGHTERS;

public class CloudflightersPlayer extends Player {
  @Override
  public float play(float bid) {
      return bid;
  }

  @Override
  public Strategy getStrategy() {
    return CLOUDFLIGHTERS;
  }
}
