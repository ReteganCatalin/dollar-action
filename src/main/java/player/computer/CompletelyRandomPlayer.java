package player.computer;

import player.Choice;

import java.util.Random;

import static player.Choice.BETRAY;
import static player.Choice.COOPERATE;
import static player.computer.StandardStrategy.RANDOM;

public class CompletelyRandomPlayer extends ComputerPlayer {

    @Override
    public Choice play() {
        return new Random().nextBoolean() ? COOPERATE : BETRAY;
    }

    @Override
    public StandardStrategy getStrategy() {
        return RANDOM;
    }
}
