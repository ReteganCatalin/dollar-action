import player.*;
import result.Result;
import result.RoundPayoffCalculator;

public class Main {

    private static final int NR_TOURNAMENTS = 100;

    public static void main(String[] args) {
        RoundPayoffCalculator payoffCalculator = new RoundPayoffCalculator();
        Player player = new AlwaysBetrayPlayer();

        long totalScore = 0;

        for (int i = 0; i < NR_TOURNAMENTS; i++) {
            Tournament tournament = new Tournament(payoffCalculator, player);
            Result results = tournament.play();
            totalScore += results.getTotalScore();
        }

        System.out.printf("Average score for %d tournaments: %d", NR_TOURNAMENTS, totalScore / NR_TOURNAMENTS);
    }
}
