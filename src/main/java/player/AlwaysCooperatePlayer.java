package player;

import static player.Choice.COOPERATE;
import static player.Strategy.ALWAYS_COOPERATE;

public class AlwaysCooperatePlayer extends Player {
    @Override
    public Choice play() {
        return COOPERATE;
    }

    @Override
    public Strategy getStrategy() {
        return ALWAYS_COOPERATE;
    }
}
