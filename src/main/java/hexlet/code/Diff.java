package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

public class Diff {
    public static List<Map<String, Object>> genDiff(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        List<Map<String, Object>> diff = new ArrayList<>();
        Set<String> keys = pullSetWithKeys(firstMap, secondMap);
        for (String key : keys) {
            Map<String, Object> temp = new LinkedHashMap<>();
            if (!firstMap.containsKey(key)) {
                temp.putAll(pullMapWithValues(key, "added", secondMap.get(key), secondMap.get(key)));
            }
            if (!secondMap.containsKey(key)) {
                temp.putAll(pullMapWithValues(key, "deleted", firstMap.get(key), firstMap.get(key)));
            }
            if (firstMap.containsKey(key) && secondMap.containsKey(key)
                    && !Objects.equals(secondMap.get(key), firstMap.get(key))) {
                temp.putAll(pullMapWithValues(key, "changed", firstMap.get(key), secondMap.get(key)));
            }
            if (firstMap.containsKey(key) && secondMap.containsKey(key)
                    && Objects.equals(firstMap.get(key), secondMap.get(key))) {
                temp.putAll(pullMapWithValues(key, "unchanged", firstMap.get(key), secondMap.get(key)));
            }
            diff.add(temp);
        }
        return diff;
    }

    private static Map<String, Object> pullMapWithValues(String key, String status, Object oldValue, Object newValue) {
        Map<String, Object> pulledMap = new LinkedHashMap<>();
        pulledMap.put("key", key);
        pulledMap.put("status", status);
        pulledMap.put("oldValue", oldValue);
        pulledMap.put("newValue", newValue);
        return pulledMap;
    }

    private static Set<String> pullSetWithKeys(Map<String, Object> firstFile, Map<String, Object> secondFile) {
        Set<String> pulledKeys = new HashSet<>();
        pulledKeys.addAll(firstFile.keySet());
        pulledKeys.addAll(secondFile.keySet());
        return pulledKeys;
    }
}
