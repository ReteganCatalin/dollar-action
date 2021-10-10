package player;

import static player.Choice.BETRAY;
import static player.Strategy.ALWAYS_BETRAY;

public class AlwaysBetrayPlayer extends Player {
    @Override
    public Choice play() {
        return BETRAY;
    }

    @Override
    public Strategy getStrategy() {
        return ALWAYS_BETRAY;
    }
}
