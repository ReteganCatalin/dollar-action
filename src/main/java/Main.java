import lombok.SneakyThrows;
import player.CustomPlayer;
import player.Player;
import result.PayoffCalculator;
import result.PrisonSentencePayoffCalculator;
import result.ResultPrinter;
import result.RoundPayoff;
import tournament.Tournament;
import tournament.TournamentRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {

  private static final int NR_TOURNAMENTS_PER_THREAD = 100;
  private static final int NR_THREADS = 4;
  private static final int NORMALIZATION_FACTOR = NR_TOURNAMENTS_PER_THREAD * NR_THREADS;

  @SneakyThrows
  public static void main(String[] args) {
    PayoffCalculator payoffCalculator = new PrisonSentencePayoffCalculator();
    final ResultPrinter resultPrinter = new ResultPrinter();

    Player player = new CustomPlayer();

    final List<TournamentRunner> threads = new ArrayList<>();
    launchThreads(payoffCalculator, player, threads);

    resultPrinter.printResults(getResults(threads), NORMALIZATION_FACTOR);
  }

  private static RoundPayoff getResults(List<TournamentRunner> threads) {
    return threads.stream()
        .map(TournamentRunner::getCombinedResults)
        .reduce(RoundPayoff::reduce)
        .orElse(RoundPayoff.builder().build());
  }

  private static void launchThreads(PayoffCalculator payoffCalculator, Player player,
                                    List<TournamentRunner> threads) throws InterruptedException {
    final CountDownLatch latch = new CountDownLatch(NR_THREADS);

    for (int t = 0; t < NR_THREADS; t++) {
      final TournamentRunner runner = new TournamentRunner(latch);
      threads.add(runner);
      for (int i = 0; i < NR_TOURNAMENTS_PER_THREAD; i++) {
        runner.addTournament(new Tournament(payoffCalculator, player));
      }
    }

    threads.forEach(TournamentRunner::run);
    latch.await();
  }
}
