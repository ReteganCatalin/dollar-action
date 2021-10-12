package player.actual;

import player.Choice;
import player.Player;
import player.Strategy;

import java.util.ArrayList;
import java.util.List;

import static player.Choice.BETRAY;
import static player.Choice.SILENT;
import static player.Strategy.ECHIPA_3;

public class EchipaTreiPlayer extends Player {
  private final List<Choice> previousChoices = new ArrayList<>();

  @Override
  public Choice play() {
    final List<Choice> allPreviousOpponentChoices = getAllPreviousOpponentChoices();
    final Choice lastOpponentChoice = getLastOpponentChoice();
    final List<Choice> last2OpponentChoices = getLastNOpponentChoices(2);
    final boolean firstChoice = isFirstChoice();
    final boolean last4ChoicesAreSilent = lastNChoicesAre(4, SILENT);

    Choice choice = SILENT;

    if(allPreviousOpponentChoices.size()<4)
    {
      choice = SILENT;
      if(firstChoice)
        choice = Choice.random();
    }
    else
    {
      if(lastNChoicesAre(2, BETRAY))
      {
        choice = BETRAY;
      }
    }

    if(last4ChoicesAreSilent)
    {
      choice = BETRAY;
    }

    previousChoices.add(choice);
    return choice;
  }

  @Override
  public Strategy getStrategy() {
    return ECHIPA_3;
  }
}
