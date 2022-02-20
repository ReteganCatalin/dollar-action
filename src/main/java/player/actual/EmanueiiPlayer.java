package player.actual;

import player.Choice;
import player.Player;
import player.Strategy;

import java.util.List;

import static player.Choice.STOP;
import static player.Choice.BID;
import static player.Strategy.EMANUEII;

public class EmanueiiPlayer extends Player {
  @Override
  public float play(float bid) {
    Choice result = Choice.random();
    if(bid == 0f)
    {
      return bid + 5f;
    }
    if (result == Choice.BID) {
      return bid + 5f;
    } else {
      return bid + 0f;
    }
  }

  @Override
  public Strategy getStrategy() {
    return EMANUEII;
  }

}
