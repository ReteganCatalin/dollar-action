package player;

import java.util.Random;

public enum Choice {
    COOPERATE,
    BETRAY;

    public static Choice random() {
        return new Random().nextBoolean() ? COOPERATE : BETRAY;
    }

    public boolean cooperates() {
        return this.equals(COOPERATE);
    }

    public boolean betrays() {
        return this.equals(BETRAY);
    }
}
