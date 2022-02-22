package player.actual;

import player.Player;
import player.Strategy;

import static player.Strategy.PRIZONIERII_DIN_ALCATRAZ;

public class PrizonieriiDinAlcatrazPlayer extends Player {
    @Override
    public float play(float bid) {
        return bid + 1f;
    }

    @Override
    public Strategy getStrategy() {
        return PRIZONIERII_DIN_ALCATRAZ;
    }
}
