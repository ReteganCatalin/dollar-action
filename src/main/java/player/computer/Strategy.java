package player.computer;

public enum Strategy {
  RANDOM(new CompletelyRandomPlayer()),
  ALWAYS_COOPERATE(new AlwaysCooperatePlayer()),
  ALWAYS_BETRAY(new AlwaysBetrayPlayer()),
  TIT_FOR_TAT(new TitForTatPlayer()),
  NOISY_COOPERATOR(new NoisyCooperatorPlayer());

  private final ComputerPlayer player;

  Strategy(ComputerPlayer player) {
    this.player = player;
  }

  public ComputerPlayer getPlayer() {
    return player;
  }
}
