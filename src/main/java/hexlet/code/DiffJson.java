package hexlet.code;

import java.util.*;

public class DiffJson {
    public static List<Map<String, Object>> getDiff(Map<String, Object> firstMapa, Map<String, Object> secondMapa) {
        List<Map<String, Object>> result = new ArrayList<>();
        Set<String> keys = pullSetWithKeys(firstMapa, secondMapa);
        for (String key : keys) {
            Map<String, Object> temp = new LinkedHashMap<>();
            if (!firstMapa.containsKey(key)) {
                temp.putAll(pullMapWithValues(key, "added", secondMapa.get(key), secondMapa.get(key)));
            }
            if (!secondMapa.containsKey(key)) {
                temp.putAll(pullMapWithValues(key, "deleted", firstMapa.get(key), firstMapa.get(key)));
            }
            if (firstMapa.containsKey(key) && secondMapa.containsKey(key) && !Objects.equals(secondMapa.get(key), firstMapa.get(key))) {
                temp.putAll(pullMapWithValues(key, "changed", firstMapa.get(key), secondMapa.get(key)));
            }
            if (firstMapa.containsKey(key) && secondMapa.containsKey(key) && Objects.equals(firstMapa.get(key), secondMapa.get(key))) {
                temp.putAll(pullMapWithValues(key, "unchanged", firstMapa.get(key), secondMapa.get(key)));
            }
            result.add(temp);
        }
        return result;
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
