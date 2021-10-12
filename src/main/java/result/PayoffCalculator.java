package result;

import player.Choice;
import player.Player;

public interface PayoffCalculator {
  void payoffPlayers(Player p1, Choice p1choice, Player p2, Choice p2Choice);
}
