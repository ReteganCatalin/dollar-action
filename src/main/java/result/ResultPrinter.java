package result;

import java.util.Map;

import static java.lang.Math.abs;

public class ResultPrinter {
    public void printResults(RoundPayoff combinedResults, int normalizationFactor) {
        final float playerPayoff = combinedResults.getPlayerPayoff() / normalizationFactor;
        final float computerPayoff = combinedResults.getComputerPayoff() / normalizationFactor;
        final float teamPayoff = combinedResults.sum() / normalizationFactor;
        Map<ResultType, Long> choiceMap = combinedResults.getResultTypes();

        System.out.printf("Player score: %.2f\n" +
                        "Computer score: %.2f\n" +
                        "Team score (should minimize): %.2f\n" +
                        "Team score special (should maximize) (*): %.2f\n\n\n" +
                        "* the absolute difference between the opponent's scores are is subtracted from the total score\n\n\n\n",
                playerPayoff,
                computerPayoff,
                teamPayoff,
                teamPayoff - (abs(playerPayoff - computerPayoff)));

        choiceMap.forEach((resultType, val) -> System.out.printf("%s: %d\n", resultType, val));
    }
}
