package round;

import lombok.Builder;
import player.Choice;
import player.Player;
import result.PayoffCalculator;

import static java.util.Optional.ofNullable;

@Builder
public class Round {

  public static final long ROUNDS_PER_TOURNAMENT = 200;

  private final PayoffCalculator payoffCalculator;
  private final Player player1;
  private final Player player2;

  public Round(PayoffCalculator payoffCalculator, Player player1, Player player2) {
    this.payoffCalculator = payoffCalculator;
    this.player1 = player1;
    this.player2 = player2;
  }

  public void play() {
    for (int i = 0; i < ROUNDS_PER_TOURNAMENT; i++) {
      playRound();
    }

    savePoints();
    reset();
  }

  private void savePoints() {
    player1.savePoints(player2);
    player2.savePoints(player1);
  }

  private void reset() {
    player1.reset();
    player2.reset();
  }

  private void playRound() {
    Choice p1Choice = ofNullable(player1.play()).orElse(Choice.random());
    Choice p2Choice = ofNullable(player2.play()).orElse(Choice.random());
    player1.addOpponentChoice(p2Choice);
    player2.addOpponentChoice(p1Choice);
    payoffCalculator.payoffPlayers(player1, p1Choice, player2, p2Choice);
  }
}
