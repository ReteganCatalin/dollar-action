package result;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RoundPayoff {
  private float playerPayoff;
  private float computerPayoff;

  public float sum() {
    return playerPayoff + computerPayoff;
  }

  public static RoundPayoff reduce(RoundPayoff r1, RoundPayoff r2) {
    return RoundPayoff.builder()
        .playerPayoff(r1.getPlayerPayoff() + r2.getPlayerPayoff())
        .computerPayoff(r1.getComputerPayoff() + r2.getComputerPayoff())
        .build();
  }

  public void normalize(long roundsPerTournament) {
    this.playerPayoff /= roundsPerTournament;
    this.computerPayoff /= roundsPerTournament;
  }
}
