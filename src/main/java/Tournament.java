import player.*;
import result.Result;
import result.RoundPayoff;
import result.RoundPayoffCalculator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Tournament {

    public static final long MAX_ROUNDS = 100;

    private final RoundPayoffCalculator calculator;
    private final Player player;
    private final Player[] strategies = new Player[Strategy.values().length];

    private final Result result = new Result();

    public Tournament(RoundPayoffCalculator calculator, Player player) {
        this.calculator = calculator;
        this.player = player;
        initStrategies();
    }

    public Result play() {
        for (Player strategy : strategies) {
            Collection<RoundPayoff> payoffs = play(strategy);
            Result strategyResult = new Result();
            strategyResult.addPayoffs(payoffs);

            System.out.println("For strategy: " + strategy.getStrategy());
            strategyResult.printResults();

            this.result.addPayoffs(payoffs);
        }

        return result;
    }

    private Collection<RoundPayoff> play(Player computer) {
        List<RoundPayoff> payoffs = new ArrayList<>();

        for (int i = 0; i < MAX_ROUNDS; i++) {
            payoffs.add(playRound(computer));
        }
        return payoffs;
    }

    private RoundPayoff playRound(Player computer) {
        Choice p1Choice = player.play();
        Choice p2Choice = computer.play();
        player.addRound(Round.builder().p1choice(p1Choice).p2choice(p2Choice).build());
        return calculator.computePayoff(p1Choice, p2Choice);
    }

    private void initStrategies() {
        strategies[0] = new CompletelyRandomPlayer();
        strategies[1] = new AlwaysCooperatePlayer();
        strategies[2] = new AlwaysBetrayPlayer();
        strategies[3] = new TitForTatPlayer();
    }
}
