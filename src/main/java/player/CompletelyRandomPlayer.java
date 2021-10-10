package player;

import java.util.Random;

import static player.Choice.BETRAY;
import static player.Choice.COOPERATE;
import static player.Strategy.RANDOM;

public class CompletelyRandomPlayer extends Player {

    @Override
    public Choice play() {
        return new Random().nextBoolean() ? COOPERATE : BETRAY;
    }

    @Override
    public Strategy getStrategy() {
        return RANDOM;
    }
}
