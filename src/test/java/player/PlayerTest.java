package player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PlayerTest {

  @Test
  void getLastRound() {
    Player p = new CustomPlayer();
    assertNull(p.getLastRound());

    final Round r1 = Round.random();
    p.addRound(r1);
    assertEquals(r1, p.getLastRound());

    final Round r2 = Round.random();
    p.addRound(r2);
    assertEquals(r2, p.getLastRound());
  }

  @Test
  void getLastNRounds() {
    Player p = new CustomPlayer();
    assertEquals(0, p.getLastNRounds(2).size());

    final int nrRoundsAdded = 5;
    for (int i = 0; i < nrRoundsAdded; i++) {
      p.addRound(Round.random());
    }

    assertEquals(3, p.getLastNRounds(3).size());
    assertEquals(nrRoundsAdded, p.getLastNRounds(nrRoundsAdded).size());
    assertEquals(nrRoundsAdded, p.getLastNRounds(nrRoundsAdded + 100).size());
  }
}
