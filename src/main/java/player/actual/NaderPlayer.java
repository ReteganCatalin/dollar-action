package player.actual;

import player.Player;
import player.Strategy;

import java.util.concurrent.ThreadLocalRandom;

import static player.Strategy.NADER;

public class NaderPlayer extends Player {
  float myCurrentBid = 0;

  @Override
  public float play(float bid) {

    if(isFirstBid())
    {
      return 51;
    }
    if(bid > 900f)
    {
      return 1000f;
    }
    if (bid < 99f)
    {
      return bid+1;
    }
    if((100-bid)<(100-myCurrentBid))
    {
      return bid+1;
    }
    return 0;
  }

  @Override
  public Strategy getStrategy() {
    return NADER;
  }
}
