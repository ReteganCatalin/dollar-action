package result;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RoundPayoff {
    private final int p1payoff;
    private final int p2payoff;

    public int sum() {
        return p1payoff + p2payoff;
    }
}
