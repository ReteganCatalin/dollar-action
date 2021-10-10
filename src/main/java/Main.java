import lombok.SneakyThrows;
import player.Player;
import player.computer.AlwaysCooperatePlayer;
import result.RoundPayoffCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {

  private static final int NR_TOURNAMENTS_PER_THREAD = 1000;
  private static final int NR_THREADS = 8;

  @SneakyThrows
  public static void main(String[] args) {
    RoundPayoffCalculator payoffCalculator = new RoundPayoffCalculator();
    Player player = new AlwaysCooperatePlayer();

    final List<TournamentRunner> threads = new ArrayList<>();
    launchThreads(payoffCalculator, player, threads);

    final double totalScore =
        threads.stream().map(TournamentRunner::computeScore).mapToDouble(value -> value).sum();

    System.out.printf("Average score for %d tournaments: %.2f", NR_TOURNAMENTS_PER_THREAD,
        totalScore / NR_TOURNAMENTS_PER_THREAD);
  }

  private static void launchThreads(RoundPayoffCalculator payoffCalculator, Player player,
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
