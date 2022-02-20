package result;

import player.Choice;
import player.Player;

public class AxelrodPayoff implements PayoffCalculator {


    public void payoffPlayers(Player p1, Choice p1choice, float p1Bid, Player p2, Choice p2Choice, float p2Bid, float objectValue) {
        if (p1choice == Choice.STOP) {
            p1.addScore(-p1Bid);
            p2.addScore(objectValue - p2Bid);
        } else {
            p1.addScore(objectValue - p1Bid);
            p2.addScore(-p2Bid);
        }

    }

}
