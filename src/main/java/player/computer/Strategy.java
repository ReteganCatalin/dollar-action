package player.computer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Strategy {
    ALWAYS_COOPERATE(new AlwaysCooperatePlayer(), true),
    ALWAYS_BETRAY(new AlwaysBetrayPlayer(), true),
    RANDOM(new CompletelyRandomPlayer(), true),
    TIT_FOR_TAT(new TitForTatPlayer(), true),
    NOISY_COOPERATOR(new NoisyCooperatorPlayer(), true),
    NOISY_BETRAYER(new NoisyBetrayerPlayer(), true);

    private final ComputerPlayer player;
    private final boolean enabled;

    Strategy(ComputerPlayer player, boolean enabled) {
        this.player = player;
        this.enabled = enabled;
    }

    public static List<Strategy> enabledStrategies() {
        return Arrays.stream(Strategy.values())
                .filter(Strategy::isEnabled)
                .collect(Collectors.toList());
    }

    public ComputerPlayer getPlayer() {
        return player;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
