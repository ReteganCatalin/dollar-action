package result;

import static java.lang.Math.abs;

public class ResultPrinter {
    public void printResults(RoundPayoff combinedResults, int normalizationFactor) {
        final float playerPayoff = combinedResults.getPlayerPayoff() / normalizationFactor;
        final float computerPayoff = combinedResults.getComputerPayoff() / normalizationFactor;
        final float teamPayoff = combinedResults.sum() / normalizationFactor;
        System.out.printf("Player score: %.2f\n" +
                        "Computer score: %.2f\n" +
                        "Team score: %.2f\n" +
                        "Team score special (*): %.2f\n\n\n" +
                        "* the absolute difference between the opponent's scores are is subtracted from the total score",
                playerPayoff,
                computerPayoff,
                teamPayoff,
                teamPayoff - (abs(playerPayoff - computerPayoff)));
    }
}
