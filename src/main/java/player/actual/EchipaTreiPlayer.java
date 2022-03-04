package player.actual;

import player.Choice;
import player.Player;
import player.Strategy;

import java.util.ArrayList;
import java.util.List;

import static player.Choice.STOP;
import static player.Choice.BID;
import static player.Strategy.ECHIPA_3;

public class EchipaTreiPlayer extends Player {
  @Override
  public float play(float bid) {
      Double d = Math.random();
      if(d > 0.1)
      {
        return bid + 1f;
      }
      else{
        return bid;
      }
  }

  @Override
  public Strategy getStrategy() {
    return ECHIPA_3;
  }
}
