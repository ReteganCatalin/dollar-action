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

  public double getP1Score() {
    return payoffs.stream().mapToDouble(RoundPayoff::getPlayerPayoff).sum();
  }

  public double getP2Score() {
    return payoffs.stream().mapToDouble(RoundPayoff::getComputerPayoff).sum();
  }

  public double getTotalScore() {
    return payoffs.stream().mapToDouble(RoundPayoff::sum).sum();
  }

  public RoundPayoff combine() {
    return payoffs.stream().reduce(RoundPayoff::reduce).orElse(RoundPayoff.builder().build());
  }

  public void printResults() {
    System.out.printf("Player 1 got a score of: %f\n", getP1Score());
    System.out.printf("Player 2 got a score of: %f\n", getP2Score());
    System.out.printf("They both got a score of %f\n\n", getTotalScore());
  }

  public void normalize(long roundsPerTournament) {
    payoffs.forEach(roundPayoff -> roundPayoff.normalize(roundsPerTournament));
  }
}
