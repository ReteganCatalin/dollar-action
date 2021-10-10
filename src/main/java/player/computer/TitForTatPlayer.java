package player.computer;

import player.Choice;
import player.Round;

import java.util.List;

import static player.Choice.COOPERATE;
import static player.computer.StandardStrategy.TIT_FOR_TAT;

public class TitForTatPlayer extends ComputerPlayer {
    @Override
    public Choice play() {
        return getLastMoveOfOpponent();
    }

    @Override
    public StandardStrategy getStrategy() {
        return TIT_FOR_TAT;
    }

    private Choice getLastMoveOfOpponent() {
        List<Round> choiceHistory = getChoiceHistory();
        if (choiceHistory.isEmpty()) {
            return COOPERATE;
        } else {
            return choiceHistory.get(choiceHistory.size() - 1).getP2choice();
        }
    }
}
