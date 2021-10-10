package player.computer;

import player.Choice;

import java.util.Random;

import static player.Choice.BETRAY;
import static player.Choice.COOPERATE;
import static player.computer.Strategy.NOISY_COOPERATOR;

public class NoisyCooperatorPlayer extends ComputerPlayer {

  private static final float NOISE_FACTOR = .98f;

  @Override
  public Choice play() {
    final double noise = new Random().nextDouble();
    return noise < NOISE_FACTOR ? COOPERATE : BETRAY;
  }

  @Override
  public Strategy getStrategy() {
    return NOISY_COOPERATOR;
  }
}
