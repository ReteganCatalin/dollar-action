package player;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Player {
    private final List<Round> choiceHistory = new ArrayList<>();

    public void addRound(Round r) {
        choiceHistory.add(r);
    }

    public abstract Choice play();
}
