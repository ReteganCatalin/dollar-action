package player.computer;

import player.Choice;
import player.Player;
import player.Strategy;

import static player.Strategy.RANDOM;

public class CompletelyRandomPlayer extends Player {

    @Override
    public float play(float bid) {
        return 100f;
    }

    @Override
    public Strategy getStrategy() {
        return RANDOM;
    }
}
