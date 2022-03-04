package player.actual;

import player.Player;
import player.Strategy;

import static player.Strategy.ONE_DOLLAR_PLAYER;

public class OneDollarPlayer extends Player
{
    @Override
    public float play(float bid) {
        return 100f;
    }

    @Override
    public Strategy getStrategy() {
        return ONE_DOLLAR_PLAYER;
    }
}
