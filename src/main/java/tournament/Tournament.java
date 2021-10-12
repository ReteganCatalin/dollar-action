package tournament;

import lombok.Builder;
import player.Choice;
import player.Player;
import result.PayoffCalculator;

import static java.util.Optional.ofNullable;

@Builder
public class Tournament {

  public static final long ROUNDS_PER_TOURNAMENT = 200;

  private final PayoffCalculator calculator;
  private final Player p1;
  private final Player p2;

  public Tournament(PayoffCalculator payoffCalculator, Player p1, Player p2) {
    this.calculator = payoffCalculator;
    this.p1 = p1;
    this.p2 = p2;
  }

  public void play() {
    for (int i = 0; i < ROUNDS_PER_TOURNAMENT; i++) {
      playRound();
    }

    savePoints();
    reset();
  }

  private void savePoints() {
    p1.savePoints(p2);
    p2.savePoints(p1);
  }

  private void reset() {
    p1.reset();
    p2.reset();
  }

  private void playRound() {
    Choice p1Choice = ofNullable(p1.play()).orElse(Choice.random());
    Choice p2Choice = ofNullable(p2.play()).orElse(Choice.random());
    p1.addOpponentChoice(p2Choice);
    p2.addOpponentChoice(p1Choice);
    calculator.payoffPlayers(p1, p1Choice, p2, p2Choice);
  }
}
