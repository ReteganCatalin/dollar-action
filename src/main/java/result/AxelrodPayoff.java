package result;

import player.Choice;
import player.Player;

public class AxelrodPayoff implements PayoffCalculator {

  public static final float BOTH_COOPERATION_BONUS = 3f;
  public static final float BETRAYER_BONUS = 5f;
  public static final float BETRAYED_BONUS = 0f;
  public static final float BOTH_BETRAYED_BONUS = 1f;

  public void payoffPlayers(Player p1, Choice p1choice, Player p2, Choice p2Choice) {
    if (bothCooperate(p1choice, p2Choice)) {
      p1.addScore(BOTH_COOPERATION_BONUS);
      p2.addScore(BOTH_COOPERATION_BONUS);
    } else if (firstCooperatesAndSecondBetrays(p1choice, p2Choice)) {
      p1.addScore(BETRAYED_BONUS);
      p2.addScore(BETRAYER_BONUS);
    } else if (firstBetraysAndSecondCooperates(p1choice, p2Choice)) {
      p1.addScore(BETRAYER_BONUS);
      p2.addScore(BETRAYED_BONUS);
    } else if (bothBetrayed(p1choice, p2Choice)) {
      p1.addScore(BOTH_BETRAYED_BONUS);
      p2.addScore(BOTH_BETRAYED_BONUS);
    }
  }

  private boolean bothCooperate(Choice player, Choice computer) {
    return player.cooperates() && computer.cooperates();
  }

  private boolean firstCooperatesAndSecondBetrays(Choice player, Choice computer) {
    return player.cooperates() && computer.betrays();
  }


  private boolean firstBetraysAndSecondCooperates(Choice player, Choice computer) {
    return player.betrays() && computer.cooperates();
  }

  private boolean bothBetrayed(Choice player, Choice computer) {
    return player.betrays() && computer.betrays();
  }
}
