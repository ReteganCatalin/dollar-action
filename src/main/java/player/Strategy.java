package player;

import player.actual.Team10Player;
import player.actual.Team11Player;
import player.actual.Team12Player;
import player.actual.Team13Player;
import player.actual.Team14Player;
import player.actual.Team15Player;
import player.actual.Team1Player;
import player.actual.Team2Player;
import player.actual.Team3Player;
import player.actual.Team4Player;
import player.actual.Team5Player;
import player.actual.Team6Player;
import player.actual.Team7Player;
import player.actual.Team8Player;
import player.actual.Team9Player;
import player.computer.CompletelyRandomPlayer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Strategy {
  RANDOM(new CompletelyRandomPlayer(), true),
  TEAM_1(new Team1Player(), true),
  TEAM_2(new Team2Player(), true),
  TEAM_3(new Team3Player(), true),
  TEAM_4(new Team4Player(), true),
  TEAM_5(new Team5Player(), true),
  TEAM_6(new Team6Player(), true),
  TEAM_7(new Team7Player(), true),
  TEAM_8(new Team8Player(), true),
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
