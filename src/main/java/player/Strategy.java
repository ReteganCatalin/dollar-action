package player;

import player.actual.OneDollarPlayer;
import player.actual.StefanPlayer;
import player.actual.NaderPlayer;
import player.actual.EchipaTreiPlayer;
import player.actual.AncaPlayer;
import player.actual.GitGoodPlayer;
import player.actual.AlexPlayer;
import player.actual.RazvanPlayer;
import player.actual.TheFarAwaysPlayer;
import player.computer.CompletelyRandomPlayer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Strategy {
  RANDOM(new CompletelyRandomPlayer(), true),
  STEFAN(new StefanPlayer(), true),
  NADER(new NaderPlayer(), true),
  RAZVAN(new RazvanPlayer(), true),
  ANCA(new AncaPlayer(), false),
  ALEX(new AlexPlayer(), true),
  ECHIPA_3(new EchipaTreiPlayer(), true),
  THE_FAR_AWAYS(new TheFarAwaysPlayer(), true),
  GIT_GOOD(new GitGoodPlayer(), true),
  ONE_DOLLAR_PLAYER(new OneDollarPlayer(), true);

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
