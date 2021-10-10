package player;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
public abstract class Player {
    private final List<Round> rounds = new ArrayList<>();

    public void addRound(Round r) {
        rounds.add(r);
    }

    public abstract Choice play();

    protected Round getLastRound() {
        return !rounds.isEmpty() ? rounds.get(rounds.size() - 1) : null;
    }

    protected List<Round> getLastNRounds(int n) {
        final int fromIndex = rounds.size() >= n ? rounds.size() - n : 0;
        return rounds.subList(fromIndex, rounds.size());
    }

    protected List<Choice> getComputerChoices() {
        return rounds.stream().map(Round::getComputerChoice).collect(toList());
    }

    protected Choice getLastComputerChoice() {
        return !rounds.isEmpty() ? rounds.get(rounds.size() - 1).getComputerChoice() : null;
    }

    protected List<Choice> getLastNComputerChoices(int n) {
        return getLastNRounds(n).stream().map(Round::getComputerChoice).collect(toList());
    }
}
