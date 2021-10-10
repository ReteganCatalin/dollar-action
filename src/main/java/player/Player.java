package player;

import lombok.Getter;

import java.util.*;

@Getter
public abstract class Player implements Strategic {
    private final List<Choice> previousOpponentChoices = new ArrayList<>();
    private final Map<Player, Float> opponentPointMap = new TreeMap<>(Comparator.comparing(Strategic::getStrategy));
    private float currentPoints = .0f;
    private long wins = 0;
    private double average = 0;

    public void addOpponentChoice(Choice c) {
        previousOpponentChoices.add(c);
    }

    public abstract Choice play();

    protected Choice getLastOpponentChoice() {
        return !previousOpponentChoices.isEmpty() ? previousOpponentChoices.get(previousOpponentChoices.size() - 1) : null;
    }

    protected List<Choice> getLastNOpponentChoices(int n) {
        final int fromIndex = previousOpponentChoices.size() >= n ? previousOpponentChoices.size() - n : 0;
        return previousOpponentChoices.subList(fromIndex, previousOpponentChoices.size());
    }

    protected List<Choice> getOpponentChoices() {
        return previousOpponentChoices;
    }

    public void addScore(float points) {
        this.currentPoints += points;
    }

    public void reset() {
        previousOpponentChoices.clear();
        currentPoints = 0;
    }

    public void addWin() {
        this.wins++;
    }

    public void savePoints(Player other) {
        if (opponentPointMap.containsKey(other)) {
            Float prev = opponentPointMap.get(other);
            opponentPointMap.put(other, prev + currentPoints);
        } else {
            opponentPointMap.put(other, currentPoints);
        }
    }

    public void computeAverage() {
        this.average = opponentPointMap.values().stream().mapToDouble(value -> value).average().getAsDouble();
    }

    public void printStats() {
        // todo: pretty print in javafx?
        System.out.printf("%s -> average: %f\n", getStrategy(), average);
    }
}
