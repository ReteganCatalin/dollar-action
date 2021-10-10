import player.*;
import player.computer.AlwaysCooperatePlayer;
import result.Result;
import result.RoundPayoffCalculator;

public class Main {

    private static final int NR_TOURNAMENTS = 1000;

    public static void main(String[] args) {
        RoundPayoffCalculator payoffCalculator = new RoundPayoffCalculator();
        Player player = new AlwaysCooperatePlayer();

        long totalScore = 0;

        for (int i = 0; i < NR_TOURNAMENTS; i++) {
            Tournament tournament = new Tournament(payoffCalculator, player);
            Result results = tournament.play();
            totalScore += results.getTotalScore();
        }

        System.out.printf("Average score for %d tournaments: %d", NR_TOURNAMENTS, totalScore / NR_TOURNAMENTS);
    }
}
