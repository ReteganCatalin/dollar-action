package player;

import java.util.List;

public class CustomPlayer extends Player {

    @Override
    public Choice play() {
        final List<Choice> computerChoices = getComputerChoices();
        final Choice lastComputerChoice = getLastComputerChoice();
        final List<Choice> last2computerChoices = getLastNComputerChoices(2);

        // todo: implement me
        return Choice.random();
    }
}
