package player.actual;

import player.Player;
import player.Strategy;

import java.util.Random;

import static player.Strategy.ANCA;

public class AncaPlayer extends Player {
  @Override
  public float play(float bid) {
    if(isFirstBid()) return 54 + new Random().nextFloat() * 10;
    else{
      if(getLastOpponentBid() > 75) return 0;
      return 55 + new Random().nextFloat() * 20;
    }

  }

  @Override
  public Strategy getStrategy() {
    return ANCA;
  }

}
