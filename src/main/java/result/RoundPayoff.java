package result;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RoundPayoff {
  private final float p1payoff;
  private final float p2payoff;

  public float sum() {
    return p1payoff + p2payoff;
  }
}
