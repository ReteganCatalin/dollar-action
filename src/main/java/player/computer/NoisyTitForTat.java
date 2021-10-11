package player.computer;

import player.Choice;
import player.Player;
import player.Strategy;

import java.util.Random;

import static player.Choice.BETRAY;
import static player.Choice.COOPERATE;
import static player.Strategy.NOISY_TIT_FOR_TAT;

public class NoisyTitForTat extends Player {
  private static final float NOISE_FACTOR = .95f;

  @Override
  public Choice play() {
    if (isFirstChoice()) {
      return COOPERATE;
    }
    final double noise = new Random().nextDouble();
    return noise > NOISE_FACTOR ? BETRAY : getLastOpponentChoice();
  }

  @Override
  public Strategy getStrategy() {
    return NOISY_TIT_FOR_TAT;
  }
}
