import player.Choice;
import player.Player;
import player.Round;
import player.computer.AlwaysBetrayPlayer;
import player.computer.AlwaysCooperatePlayer;
import player.computer.CompletelyRandomPlayer;
import player.computer.ComputerPlayer;
import player.computer.NoisyCooperatorPlayer;
import player.computer.StandardStrategy;
import player.computer.TitForTatPlayer;
import result.PayoffCalculator;
import result.Result;
import result.RoundPayoff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static java.util.Optional.ofNullable;

public class Tournament {

  public static final long ROUNDS_PER_TOURNAMENT = 1000;

  private final PayoffCalculator calculator;
  private final Player player;
  private final ComputerPlayer[] strategies = new ComputerPlayer[StandardStrategy.values().length];

  private final Result result = new Result();

  public Tournament(PayoffCalculator calculator, Player player) {
    this.calculator = calculator;
    this.player = player;
    initStrategies();
  }

  public void play() {

    ComputerPlayer strategy = getRandomStrategy();
    Collection<RoundPayoff> payoffs = play(strategy);
    Result strategyResult = new Result();
    strategyResult.addPayoffs(payoffs);

    this.result.addPayoffs(payoffs);
  }

  private Collection<RoundPayoff> play(Player computer) {
    List<RoundPayoff> payoffs = new ArrayList<>();

    for (int i = 0; i < ROUNDS_PER_TOURNAMENT; i++) {
      payoffs.add(playRound(computer));
    }

    return payoffs;
  }

  private RoundPayoff playRound(Player computer) {
    Choice p1Choice = ofNullable(player.play()).orElse(Choice.random());
    Choice p2Choice = computer.play();
    player.addRound(Round.builder().playerChoice(p1Choice).computerChoice(p2Choice).build());
    return calculator.computePayoff(p1Choice, p2Choice);
  }

  private void initStrategies() {
    strategies[0] = new CompletelyRandomPlayer();
    strategies[1] = new AlwaysCooperatePlayer();
    strategies[2] = new AlwaysBetrayPlayer();
    strategies[3] = new TitForTatPlayer();
    strategies[4] = new NoisyCooperatorPlayer();
  }

  private ComputerPlayer getRandomStrategy() {
    final int index = new Random().nextInt(StandardStrategy.values().length);
    return strategies[index];
  }

  public Result getResult() {
    return result;
  }
}
