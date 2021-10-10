package player.computer;

import player.Choice;
import player.Round;

import java.util.List;

import static player.Choice.COOPERATE;
import static player.computer.Strategy.TIT_FOR_TAT;

public class TitForTatPlayer extends ComputerPlayer {
    @Override
    public Choice play() {
        return getLastMoveOfOpponent();
    }

    @Override
    public Strategy getStrategy() {
        return TIT_FOR_TAT;
    }

    private Choice getLastMoveOfOpponent() {
        List<Round> choiceHistory = getRounds();
        if (choiceHistory.isEmpty()) {
            return COOPERATE;
        } else {
            return choiceHistory.get(choiceHistory.size() - 1).getComputerChoice();
        }
    }
}
