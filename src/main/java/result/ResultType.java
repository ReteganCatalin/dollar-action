package result;

import player.Choice;

import java.util.Map;
import java.util.TreeMap;

public enum ResultType {
    COOP_COOP,
    COOP_BETRAY,
    BETRAY_COOP,
    BETRAY_BETRAY;

    public static Map<ResultType, Long> emptyResultMap() {
        Map<ResultType, Long> emptyTypeMap = new TreeMap<>();
        for (ResultType value : ResultType.values()) {
            emptyTypeMap.put(value, 0L);
        }
        return emptyTypeMap;
    }

    public static ResultType fromChoices(Choice c1, Choice c2) {
        if (c1.cooperates() && c2.cooperates()) {
            return COOP_COOP;
        } else if (c1.cooperates() && c2.betrays()) {
            return COOP_BETRAY;
        } else if (c1.betrays() && c2.cooperates()) {
            return BETRAY_COOP;
        } else {
            return BETRAY_BETRAY;
        }
    }
}
