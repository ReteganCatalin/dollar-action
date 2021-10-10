package player.computer;

import player.Choice;

import static player.Choice.BETRAY;
import static player.computer.StandardStrategy.ALWAYS_BETRAY;

public class AlwaysBetrayPlayer extends ComputerPlayer {
    @Override
    public Choice play() {
        return BETRAY;
    }

    @Override
    public StandardStrategy getStrategy() {
        return ALWAYS_BETRAY;
    }
}
