package player;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Predicate;

@Getter
public abstract class Player implements Strategic {
  private final List<Choice> previousOpponentChoices = new ArrayList<>();
  private final Map<Player, Float> opponentPointMap = new TreeMap<>(Comparator.comparing(Strategic::getStrategy));
  private float currentPoints = .0f;
  private double average = 0;

  public void addOpponentChoice(Choice c) {
    previousOpponentChoices.add(c);
  }

  public abstract Choice play();

  public void addScore(float points) {
    this.currentPoints += points;
  }

  public void reset() {
    previousOpponentChoices.clear();
    currentPoints = 0;
  }

  public void savePoints(Player other) {
    final float updatedPoints = opponentPointMap.getOrDefault(other, .0f) + currentPoints;
    opponentPointMap.put(other, updatedPoints);
  }

  public void computeAverage() {
    this.average = opponentPointMap.values().stream()
        .mapToDouble(value -> value)
        .average()
        .orElse(.0f);
  }


  protected Choice getLastOpponentChoice() {
    return !previousOpponentChoices.isEmpty() ?
        previousOpponentChoices.get(previousOpponentChoices.size() - 1) : null;
  }

  protected List<Choice> getLastNOpponentChoices(int n) {
    final int fromIndex = previousOpponentChoices.size() >= n ? previousOpponentChoices.size() - n : 0;
    return previousOpponentChoices.subList(fromIndex, previousOpponentChoices.size());
  }

  protected List<Choice> getAllPreviousOpponentChoices() {
    return previousOpponentChoices;
  }

  protected boolean isFirstChoice() {
    return previousOpponentChoices.isEmpty();
  }

  protected boolean lastNChoicesAre(int n, Choice c) {
    return getLastNOpponentChoices(n).stream()
        .allMatch(Predicate.isEqual(c));
  }
}
