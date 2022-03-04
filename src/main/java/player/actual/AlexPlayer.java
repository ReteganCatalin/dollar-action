package player.actual;

import player.Player;
import player.Strategy;

import static player.Strategy.ALEX;

public class AlexPlayer extends Player {
  @Override
  public float play(float bid) {
    if (isFirstBid()) {
        return (float) Math.random() * 33.0f;
      } else {
        if (bid < 66.0f) {
        return (float) Math.random() + 5.0f;
      } else {
        return 0.0f;
      }
    }
  }

  @Override
  public Strategy getStrategy() {
    return ALEX;
  }
}
