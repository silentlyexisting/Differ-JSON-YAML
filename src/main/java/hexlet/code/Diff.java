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
        Set<String> keys = allKeys(firstMap, secondMap);
        for (String key : keys) {
            Map<String, Object> node = new LinkedHashMap<>();
            if (!firstMap.containsKey(key)) {
                node = createDiffNode(key, "added", secondMap.get(key), secondMap.get(key));
            }
            if (!secondMap.containsKey(key)) {
                node = createDiffNode(key, "deleted", firstMap.get(key), firstMap.get(key));
            }
            if (firstMap.containsKey(key) && secondMap.containsKey(key)
                    && !Objects.equals(secondMap.get(key), firstMap.get(key))) {
                node = createDiffNode(key, "changed", firstMap.get(key), secondMap.get(key));
            }
            if (firstMap.containsKey(key) && secondMap.containsKey(key)
                    && Objects.equals(firstMap.get(key), secondMap.get(key))) {
                node = createDiffNode(key, "unchanged", firstMap.get(key), secondMap.get(key));
            }
            diff.add(node);
        }
        return diff;
    }

    private static Map<String, Object> createDiffNode(String key, String status, Object oldValue, Object newValue) {
        Map<String, Object> node = new LinkedHashMap<>();
        node.put("key", key);
        node.put("status", status);
        node.put("oldValue", oldValue);
        node.put("newValue", newValue);
        return node;
    }

    private static Set<String> allKeys(Map<String, Object> firstFile, Map<String, Object> secondFile) {
        Set<String> pulledKeys = new HashSet<>();
        pulledKeys.addAll(firstFile.keySet());
        pulledKeys.addAll(secondFile.keySet());
        return pulledKeys;
    }
}
