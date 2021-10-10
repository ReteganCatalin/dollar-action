package result;

import java.util.HashMap;
import java.util.Map;

public enum ResultType {
    COOP_COOP,
    COOP_BETRAY,
    BETRAY_COOP,
    BETRAY_BETRAY;

    public static Map<ResultType, Long> emptyResultMap() {
        HashMap<ResultType, Long> emptyTypeMap = new HashMap<>();
        for (ResultType value : ResultType.values()) {
            emptyTypeMap.put(value, 0L);
        }
        return emptyTypeMap;
    }
}
