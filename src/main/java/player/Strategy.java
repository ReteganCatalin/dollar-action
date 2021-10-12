package player;

import player.actual.Team10Player;
import player.actual.Team11Player;
import player.actual.Team12Player;
import player.actual.Team13Player;
import player.actual.Team14Player;
import player.actual.Team15Player;
import player.actual.ABCPlayer;
import player.actual.CloudflightersPlayer;
import player.actual.PrizonieriiDinAlcatrazPlayer;
import player.actual.EmanueiiPlayer;
import player.actual.NashNonEquilibriumPlayer;
import player.actual.EchipaTreiPlayer;
import player.actual.TheFarAwaysPlayer;
import player.actual.GitGoodPlayer;
import player.actual.Team9Player;
import player.computer.CompletelyRandomPlayer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Strategy {
  RANDOM(new CompletelyRandomPlayer(), true),
  ABC(new ABCPlayer(), true),
  CLOUDFLIGHTERS(new CloudflightersPlayer(), true),
  PRIZONIERII_DIN_ALCATRAZ(new PrizonieriiDinAlcatrazPlayer(), true),
  EMANUEII(new EmanueiiPlayer(), true),
  NASH_NON_EQ(new NashNonEquilibriumPlayer(), true),
  ECHIPA_3(new EchipaTreiPlayer(), true),
  THE_FAR_AWAYS(new TheFarAwaysPlayer(), true),
  GIT_GOOD(new GitGoodPlayer(), true),
  TEAM_9(new Team9Player(), true),
  TEAM_10(new Team10Player(), true),
  TEAM_11(new Team11Player(), true),
  TEAM_12(new Team12Player(), true),
  TEAM_13(new Team13Player(), true),
  TEAM_14(new Team14Player(), true),
  TEAM_15(new Team15Player(), true);

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
