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
      return bid + 0f;
  }

  @Override
  public Strategy getStrategy() {
    return ECHIPA_3;
  }
}
