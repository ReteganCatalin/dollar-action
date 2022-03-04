package player.actual;

import player.Player;
import player.Strategy;

import static player.Strategy.RAZVAN;

public class RazvanPlayer extends Player
{
    @Override
    public float play(float bid)
    {
        if (!this.isFirstBid() && bid == 0)
        {
            return 1;
        }
        return 0;
    }

    @Override
    public Strategy getStrategy()
    {
        return RAZVAN;
    }
}
