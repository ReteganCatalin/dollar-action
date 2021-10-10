import lombok.SneakyThrows;
import player.Player;
import player.Strategy;
import result.PayoffCalculator;
import result.AxelrodPayoff;
import tournament.Tournament;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        PayoffCalculator payoffCalculator = new AxelrodPayoff();

        startRoundRobin(payoffCalculator);
    }

    private static void startRoundRobin(PayoffCalculator payoffCalculator) {
        List<Player> strategies = Strategy.enabledStrategies().stream().map(Strategy::getPlayer).collect(Collectors.toList());

        List<Tournament> rounds = new ArrayList<>();
        for (int i = 0; i < strategies.size(); i++) {
            for (int j = i + 1; j < strategies.size(); j++) {
                rounds.add(new Tournament(payoffCalculator, strategies.get(i), strategies.get(j)));
            }
        }

        rounds.forEach(Tournament::play);
        strategies.forEach(Player::computeAverage);

        strategies.sort(Comparator.comparingDouble(Player::getAverage).reversed());
        strategies.forEach(Player::printStats);
    }

}
