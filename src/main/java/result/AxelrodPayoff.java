package result;

import player.Choice;
import player.Player;

public class AxelrodPayoff implements PayoffCalculator {

  public static final float BOTH_SILENT_BONUS = 3f;
  public static final float BETRAYER_BONUS = 5f;
  public static final float BETRAYED_BONUS = 0f;
  public static final float BOTH_BETRAYED_BONUS = 1f;

  public void payoffPlayers(Player p1, Choice p1choice, Player p2, Choice p2Choice) {
    if (bothStaySilent(p1choice, p2Choice)) {
      p1.addScore(BOTH_SILENT_BONUS);
      p2.addScore(BOTH_SILENT_BONUS);
    } else if (firstStaysSilentAndSecondBetrays(p1choice, p2Choice)) {
      p1.addScore(BETRAYED_BONUS);
      p2.addScore(BETRAYER_BONUS);
    } else if (firstBetraysAndSecondStaysSilent(p1choice, p2Choice)) {
      p1.addScore(BETRAYER_BONUS);
      p2.addScore(BETRAYED_BONUS);
    } else if (bothBetrayed(p1choice, p2Choice)) {
      p1.addScore(BOTH_BETRAYED_BONUS);
      p2.addScore(BOTH_BETRAYED_BONUS);
    }
  }

  private boolean bothStaySilent(Choice player, Choice computer) {
    return player.isSilent() && computer.isSilent();
  }

  private boolean firstStaysSilentAndSecondBetrays(Choice player, Choice computer) {
    return player.isSilent() && computer.betrays();
  }


  private boolean firstBetraysAndSecondStaysSilent(Choice player, Choice computer) {
    return player.betrays() && computer.isSilent();
  }

  private boolean bothBetrayed(Choice player, Choice computer) {
    return player.betrays() && computer.betrays();
  }
}
