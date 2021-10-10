package player.computer;

import player.Choice;

import static player.Choice.COOPERATE;
import static player.computer.Strategy.ALWAYS_COOPERATE;

public class AlwaysCooperatePlayer extends ComputerPlayer {
    @Override
    public Choice play() {
        return COOPERATE;
    }

    @Override
    public Strategy getStrategy() {
        return ALWAYS_COOPERATE;
    }
}
