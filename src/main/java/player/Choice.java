package player;

import java.util.Random;

public enum Choice {
  BID,
  STOP;

  public static Choice random() {
    return new Random().nextBoolean() ? BID : STOP;
  }

  public boolean isSilent() {
    return this.equals(BID);
  }

  public boolean betrays() {
    return this.equals(STOP);
  }
}
