package player;

import player.computer.AlwaysBetrayPlayer;
import player.computer.AlwaysSilentPlayer;
import player.computer.CompletelyRandomPlayer;
import player.computer.NoisyBetrayerPlayer;
import player.computer.NoisySilentPlayer;
import player.computer.NoisyTitForTat;
import player.computer.TitForTatPlayer;
import player.computer.TitForTwoTatsPlayer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Strategy {
  ALWAYS_SILENT(new AlwaysSilentPlayer(), true),
  ALWAYS_BETRAY(new AlwaysBetrayPlayer(), true),
  RANDOM(new CompletelyRandomPlayer(), true),
  TIT_FOR_TAT(new TitForTatPlayer(), true),
  NOISY_SILENT(new NoisySilentPlayer(), true),
  NOISY_BETRAYER(new NoisyBetrayerPlayer(), true),
  TIT_FOR_TWO_TATS(new TitForTwoTatsPlayer(), true),
  NOISY_TIT_FOR_TAT(new NoisyTitForTat(), true),
  CUSTOM(new CustomPlayer(), true);

  private final Player player;
  private final boolean enabled;

  Strategy(Player player, boolean enabled) {
    this.player = player;
    this.enabled = enabled;
  }

  public static List<Strategy> enabledStrategies() {
    return Arrays.stream(Strategy.values())
        .filter(Strategy::isEnabled)
        .collect(Collectors.toList());
  }

  public Player getPlayer() {
    return player;
  }

  public boolean isEnabled() {
    return enabled;
  }
}
