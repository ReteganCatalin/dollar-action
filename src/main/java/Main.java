import lombok.SneakyThrows;
import player.Player;
import player.Strategy;
import result.AxelrodPayoff;
import result.PayoffCalculator;
import results.ResultsTable;
import round.Round;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.toList;
import static player.Strategy.enabledStrategies;

public class Main {

  @SneakyThrows
  public static void main(String[] args) {
    final PayoffCalculator payoffCalculator = new AxelrodPayoff();
    final ResultsTable resultsTable = new ResultsTable();

    startRoundRobin(payoffCalculator, resultsTable);
  }

  private static void startRoundRobin(PayoffCalculator payoffCalculator, ResultsTable resultsTable) {
    List<Player> strategies = enabledStrategies().stream()
        .map(Strategy::getPlayer).collect(toList());

    List<Round> rounds = createRounds(payoffCalculator, strategies);

    rounds.forEach(Round::play);

    strategies.forEach(Player::computeAverage);
    strategies.sort(comparingDouble(Player::getAverage).reversed());
    strategies.forEach(resultsTable::addDataPoints);
  }

  private static List<Round> createRounds(PayoffCalculator payoffCalculator, List<Player> strategies) {
    List<Round> rounds = new ArrayList<>();
    for (int i = 0; i < strategies.size(); i++) {
      for (int j = i + 1; j < strategies.size(); j++) {
        rounds.add(Round.builder()
            .payoffCalculator(payoffCalculator)
            .player1(strategies.get(i))
            .player2(strategies.get(j))
            .build()
        );
      }
    }
    return rounds;
  }

}
