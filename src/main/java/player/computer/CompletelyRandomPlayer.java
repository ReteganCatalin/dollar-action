package player.computer;

import player.Choice;

import static player.computer.Strategy.RANDOM;

public class CompletelyRandomPlayer extends ComputerPlayer {

    @Override
    public Choice play() {
        return Choice.random();
    }

    @Override
    public Strategy getStrategy() {
        return RANDOM;
    }
}
