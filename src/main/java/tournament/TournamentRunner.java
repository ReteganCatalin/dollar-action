package tournament;

import result.Result;
import result.RoundPayoff;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class TournamentRunner implements Runnable {

  private final List<Tournament> tournaments = new ArrayList<>();
  private final CountDownLatch latch;

  public TournamentRunner(CountDownLatch latch) {
    this.latch = latch;
  }

  @Override
  public void run() {
    tournaments.forEach(Tournament::play);
    latch.countDown();
  }

  public void addTournament(Tournament t) {
    tournaments.add(t);
  }

  public double getTotalScore() {
    return tournaments.stream().map(Tournament::getResult).mapToDouble(Result::getTotalScore).sum();
  }

  public RoundPayoff getCombinedResults() {
    return tournaments.stream().map(Tournament::getResult)
        .map(Result::combine)
        .reduce(RoundPayoff::reduce)
        .orElse(RoundPayoff.builder().build());
  }
}
