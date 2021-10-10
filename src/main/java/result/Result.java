package result;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
public class Result {
    @Builder.Default
    private final List<RoundPayoff> payoffs = new ArrayList<>();

    public void addPayoffs(Collection<RoundPayoff> payoffs) {
        this.payoffs.addAll(payoffs);
    }

    public double getP1Score() {
        return payoffs.stream().mapToDouble(RoundPayoff::getPlayerPayoff).sum();
    }

    public double getP2Score() {
        return payoffs.stream().mapToDouble(RoundPayoff::getComputerPayoff).sum();
    }

    public double getTotalScore() {
        return payoffs.stream().mapToDouble(RoundPayoff::sum).sum();
    }

    public RoundPayoff reduce() {
        return payoffs.stream()
                .reduce(RoundPayoff::reduce)
                .orElse(RoundPayoff.empty());
    }

    public void normalize(long roundsPerTournament) {
        payoffs.forEach(roundPayoff -> roundPayoff.normalize(roundsPerTournament));
    }
}
