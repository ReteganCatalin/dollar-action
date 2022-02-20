package player;

import player.actual.ABCPlayer;
import player.actual.CloudflightersPlayer;
import player.actual.EchipaTreiPlayer;
import player.actual.EmanueiiPlayer;
import player.actual.GitGoodPlayer;
import player.actual.NashNonEquilibriumPlayer;
import player.actual.PrizonieriiDinAlcatrazPlayer;
import player.actual.TheFarAwaysPlayer;
import player.computer.CompletelyRandomPlayer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Strategy {
  RANDOM(new CompletelyRandomPlayer(), true),
  ABC(new ABCPlayer(), true),
  CLOUDFLIGHTERS(new CloudflightersPlayer(), false),
  PRIZONIERII_DIN_ALCATRAZ(new PrizonieriiDinAlcatrazPlayer(), true),
  EMANUEII(new EmanueiiPlayer(), true),
  NASH_NON_EQ(new NashNonEquilibriumPlayer(), true),
  ECHIPA_3(new EchipaTreiPlayer(), false),
  THE_FAR_AWAYS(new TheFarAwaysPlayer(), false),
  GIT_GOOD(new GitGoodPlayer(), false);

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
