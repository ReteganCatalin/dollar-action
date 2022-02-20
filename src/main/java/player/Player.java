package player;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
public abstract class Player implements Strategic {
    private final List<Float> previousOpponentMaxBids = new ArrayList<>();
    private final List<Float> previousOpponentBids = new ArrayList<>();
    private final List<Float> winningBids = new ArrayList<>();
    private final Map<Player, Float> opponentPointMap = new TreeMap<>(Comparator.comparing(Strategic::getStrategy));
    private float currentPoints = .0f;
    private double average = 0;
    private float objectValue = 100f;

    public void addOpponentMaxBid(float bid) {
        previousOpponentMaxBids.add(bid);
    }

    public void addOpponentBid(float bid) {
        previousOpponentBids.add(bid);
    }

    public void addWinningBid(float bid) {
        winningBids.add(bid);
    }

    public abstract float play(float bid);

    public void addScore(float points) {
        this.currentPoints += points;
    }

    public void reset() {
        previousOpponentMaxBids.clear();
        winningBids.clear();
        previousOpponentBids.clear();
        currentPoints = .0f;
    }

    public void resetRound() {
        previousOpponentBids.clear();
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


    protected Float getLastOpponentMaxBid() {
        return !previousOpponentMaxBids.isEmpty() ?
                previousOpponentMaxBids.get(previousOpponentMaxBids.size() - 1) : null;
    }

    protected List<Float> getLastNOpponentMaxBids(int n) {
        final int fromIndex = previousOpponentMaxBids.size() >= n ? previousOpponentMaxBids.size() - n : 0;
        return previousOpponentMaxBids.subList(fromIndex, previousOpponentMaxBids.size());
    }

    protected List<Float> getAllPreviousOpponentMaxBids() {
        return previousOpponentMaxBids;
    }

    protected boolean isFirstBid() {
        return previousOpponentMaxBids.isEmpty();
    }

    protected boolean lastNMaxBidsAreUnderBid(int n, float bid) {
        return getLastNOpponentMaxBids(n).stream()
                .allMatch(p -> p < bid);
    }

    protected boolean lastNMaxBidsAreOverBid(int n, float bid) {
        return getLastNOpponentMaxBids(n).stream()
                .allMatch(p -> p < bid);
    }

    protected Float getLastOpponentBid() {
        return !previousOpponentBids.isEmpty() ?
                previousOpponentBids.get(previousOpponentBids.size() - 1) : null;
    }

    protected List<Float> getLastNOpponentBids(int n) {
        final int fromIndex = previousOpponentBids.size() >= n ? previousOpponentBids.size() - n : 0;
        return previousOpponentBids.subList(fromIndex, previousOpponentBids.size());
    }

    protected List<Float> getAllPreviousOpponentBids() {
        return previousOpponentBids;
    }

    protected Float getLastWinningBid() {
        return !winningBids.isEmpty() ?
                previousOpponentMaxBids.get(previousOpponentMaxBids.size() - 1) : null;
    }

    protected List<Float> getLastNWinningBids(int n) {
        final int fromIndex = winningBids.size() >= n ? winningBids.size() - n : 0;
        return winningBids.subList(fromIndex, winningBids.size());
    }

    protected List<Float> getAllWinningBids() {
        return winningBids;
    }

    protected boolean lastNWinningBidsAreUnderBid(int n, float bid) {
        return getLastNWinningBids(n).stream()
                .allMatch(p -> p < bid);
    }

    protected boolean lastNWinningBidsAreOverBid(int n, float bid) {
        return getLastNWinningBids(n).stream()
                .allMatch(p -> p < bid);
    }

}
