package result;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class Result {
    private final List<RoundPayoff> payoffs = new ArrayList<>();

    public void addPayoff(RoundPayoff payoff) {
        payoffs.add(payoff);
    }

    public void addPayoffs(Collection<RoundPayoff> payoffs) {
        this.payoffs.addAll(payoffs);
    }

    public long getP1Score() {
        return payoffs.stream().mapToLong(RoundPayoff::getP1payoff).sum();
    }

    public long getP2Score() {
        return payoffs.stream().mapToLong(RoundPayoff::getP2payoff).sum();
    }

    public long getTotalScore() {
        return payoffs.stream().mapToLong(RoundPayoff::sum).sum();
    }

    public void printResults() {
        System.out.printf("Player 1 got a score of: %d\n", getP1Score());
        System.out.printf("Player 2 got a score of: %d\n", getP2Score());
        System.out.printf("They both got a score of %d\n\n", getTotalScore());
    }
}
