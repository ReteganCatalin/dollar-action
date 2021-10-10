package result;

import player.Choice;

public interface PayoffCalculator {
    RoundPayoff computePayoff(Choice p1choice, Choice p2Choice);
}
