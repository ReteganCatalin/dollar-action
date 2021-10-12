package player;

import java.util.Random;

public enum Choice {
  SILENT,
  BETRAY;

  public static Choice random() {
    return new Random().nextBoolean() ? SILENT : BETRAY;
  }

  public boolean isSilent() {
    return this.equals(SILENT);
  }

  public boolean betrays() {
    return this.equals(BETRAY);
  }
}
