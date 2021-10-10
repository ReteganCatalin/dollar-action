package player.computer;

import player.Choice;

import static player.Choice.COOPERATE;
import static player.computer.StandardStrategy.ALWAYS_COOPERATE;

public class AlwaysCooperatePlayer extends ComputerPlayer {
    @Override
    public Choice play() {
        return COOPERATE;
    }

    @Override
    public StandardStrategy getStrategy() {
        return ALWAYS_COOPERATE;
    }
}
