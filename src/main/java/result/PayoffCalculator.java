package result;

import player.Choice;
import player.Player;

public interface PayoffCalculator {
    void payoffPlayers(Player p1, Choice p1choice, float p1LastBid, Player p2, Choice p2Choice, float p2LastBid, float objectValue);
}
