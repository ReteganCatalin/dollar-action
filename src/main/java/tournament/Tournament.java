package tournament;

import player.Choice;
import player.Player;
import player.Round;
import player.computer.ComputerPlayer;
import player.computer.Strategy;
import result.PayoffCalculator;
import result.Result;
import result.RoundPayoff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static java.util.Optional.ofNullable;
import static player.computer.Strategy.enabledStrategies;
import static result.ResultType.fromChoices;

public class Tournament {

    public static final long ROUNDS_PER_TOURNAMENT = 100;

    private final PayoffCalculator calculator;
    private final Player player;

    private final Result result = Result.builder().build();

    public Tournament(PayoffCalculator calculator, Player player) {
        this.calculator = calculator;
        this.player = player;
    }

    public void play() {
        ComputerPlayer strategy = getRandomStrategy();
        Collection<RoundPayoff> payoffs = play(strategy);

        this.result.addPayoffs(payoffs);
        this.result.normalize(ROUNDS_PER_TOURNAMENT);
    }

    public Result getResult() {
        return result;
    }

    private Collection<RoundPayoff> play(Player computer) {
        List<RoundPayoff> payoffs = new ArrayList<>();

        for (int i = 0; i < ROUNDS_PER_TOURNAMENT; i++) {
            payoffs.add(playRound(computer));
        }

        return payoffs;
    }

    private RoundPayoff playRound(Player computer) {
        Choice playerChoice = ofNullable(player.play()).orElse(Choice.random());
        Choice computerChoice = computer.play();
        player.addRound(Round.builder().playerChoice(playerChoice).computerChoice(computerChoice).build());
        return calculator.computePayoff(playerChoice, computerChoice, fromChoices(playerChoice, computerChoice));
    }

    private ComputerPlayer getRandomStrategy() {
        final List<Strategy> strategies = enabledStrategies();
        final int index = new Random().nextInt(strategies.size());
        return strategies.get(index).getPlayer();
    }
}
