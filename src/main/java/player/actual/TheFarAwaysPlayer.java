package player.actual;

import player.Choice;
import player.Player;
import player.Strategy;

import java.util.List;
import java.util.Random;

import static player.Choice.STOP;
import static player.Choice.BID;
import static player.Strategy.THE_FAR_AWAYS;

public class TheFarAwaysPlayer extends Player {
  @Override
  public float play(float bid) {
      return 99f;
  }

  @Override
  public Strategy getStrategy() {
    return THE_FAR_AWAYS;
  }
}
