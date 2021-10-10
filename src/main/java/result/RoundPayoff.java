package result;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Builder
@Getter
public class RoundPayoff {

    @Builder.Default
    private final Map<ResultType, Long> resultTypes = new HashMap<>();
    @Builder.Default
    private float playerPayoff = 0.0f;
    @Builder.Default
    private float computerPayoff = 0.0f;

    public static RoundPayoff reduce(RoundPayoff r1, RoundPayoff r2) {
        Map<ResultType, Long> outputTypeMap = combine(r1.getResultTypes(), r2.getResultTypes());
        return RoundPayoff.builder()
                .playerPayoff(r1.getPlayerPayoff() + r2.getPlayerPayoff())
                .computerPayoff(r1.getComputerPayoff() + r2.getComputerPayoff())
                .resultTypes(outputTypeMap)
                .build();
    }

    public static RoundPayoffBuilder init() {
        return RoundPayoff.builder()
                .resultTypes(ResultType.emptyResultMap());
    }

    public static RoundPayoff empty() {
        return init().build();
    }

    public float sum() {
        return playerPayoff + computerPayoff;
    }

    public void normalize(long roundsPerTournament) {
        this.playerPayoff /= roundsPerTournament;
        this.computerPayoff /= roundsPerTournament;
    }

    public void setType(ResultType resultType) {
        resultTypes.put(resultType, 1L);
    }

    private static Map<ResultType, Long> combine(Map<ResultType, Long> m1, Map<ResultType, Long> m2) {
        HashMap<ResultType, Long> combinedTypeMap = new HashMap<>();
        for (ResultType value : ResultType.values()) {
            combinedTypeMap.put(value, m1.get(value) + m2.get(value));
        }
        return combinedTypeMap;
    }
}
