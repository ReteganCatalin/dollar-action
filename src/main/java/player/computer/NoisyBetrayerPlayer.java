package player.computer;

import player.Choice;
import player.Player;
import player.Strategy;

import java.util.Random;

import static player.Choice.BETRAY;
import static player.Choice.SILENT;
import static player.Strategy.NOISY_BETRAYER;

public class NoisyBetrayerPlayer extends Player {
  private static final float NOISE_FACTOR = .98f;

  @Override
  public Choice play() {
    final double noise = new Random().nextDouble();
    return noise < NOISE_FACTOR ? BETRAY : SILENT;
  }

  @Override
  public Strategy getStrategy() {
    return NOISY_BETRAYER;
  }
}
