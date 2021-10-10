package player.computer;

import player.Choice;
import player.Player;
import player.Strategy;

import java.util.List;

import static player.Choice.COOPERATE;
import static player.Strategy.TIT_FOR_TAT;

public class TitForTatPlayer extends Player {
    @Override
    public Choice play() {
        return getLastMoveOfOpponent();
    }

    @Override
    public Strategy getStrategy() {
        return TIT_FOR_TAT;
    }

    private Choice getLastMoveOfOpponent() {
        List<Choice> choiceHistory = getPreviousOpponentChoices();
        if (choiceHistory.isEmpty()) {
            return COOPERATE;
        } else {
            return choiceHistory.get(choiceHistory.size() - 1);
        }
    }
}
