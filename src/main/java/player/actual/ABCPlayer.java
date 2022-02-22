package player.actual;
import player.Player;
import player.Strategy;


import static player.Strategy.ABC;

public class ABCPlayer extends Player {
  @Override
  public float play(float bid) {
    return bid;
  }

  @Override
  public Strategy getStrategy() {
    return ABC;
  }
}
