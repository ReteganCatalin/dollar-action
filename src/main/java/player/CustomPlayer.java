package player;

import java.util.List;

public class CustomPlayer extends Player {

  @Override
  public Choice play() {
    final List<Choice> computerChoices = getComputerChoices();
    final Choice lastComputerChoice = getLastComputerChoice();
    final List<Choice> last5computerChoices = getLastNComputerChoices(5);

    // todo: implement me
    return null;
  }
}
