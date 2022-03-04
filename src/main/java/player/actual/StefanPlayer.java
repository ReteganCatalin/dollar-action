package player.actual;
import player.Player;
import player.Strategy;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static player.Strategy.STEFAN;

public class StefanPlayer extends Player {
  private int limit = ThreadLocalRandom.current().nextInt(110, 200 + 1);
  private int numberOfWinningBids = 0;

  @Override
  public float play(float bid) {
    if (getAllWinningBids().size() != numberOfWinningBids) {
      limit =  ThreadLocalRandom.current().nextInt(110, 200 + 1);
      numberOfWinningBids = getAllWinningBids().size();
    }
    if (bid < limit)
    {
      return bid + 0.01f;
    }
    return 0.0f;
  }
  @Override
  public Strategy getStrategy() {
    return STEFAN;
  }
}
