package player.computer;

import player.Choice;

import static player.computer.StandardStrategy.RANDOM;

public class CompletelyRandomPlayer extends ComputerPlayer {

  @Override
  public Choice play() {
    return Choice.random();
  }

  @Override
  public StandardStrategy getStrategy() {
    return RANDOM;
  }
}
