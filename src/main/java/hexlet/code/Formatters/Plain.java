package hexlet.code.Formatters;

import java.util.*;
import java.util.stream.Collectors;

public class Plain {
    public static String buildResult(List<Map<String, Object>> pulledMapWithValues) {
        Map<String, Object> temp = unpackList(pulledMapWithValues);
        String result = buildString(temp);
        return result.substring(0, result.length() - 1);
    }

    private static Map<String, Object> unpackList(List<Map<String, Object>> pulledValues) {
        Map<String, Object> result = new LinkedHashMap<>();
        for (Map<String, Object> map : pulledValues) {
            result.putAll(changeStatus(map));
        }
        return result;
    }

    private static Object changeValue(Object value) {
        if (value instanceof  Arrays || value instanceof List || value instanceof Map) {
            return "[complex value]";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        return value;
    }

    private static Map<String, Object> changeStatus(Map<String, Object> pulledMapWithValues) {
        Map<String, Object> result = new LinkedHashMap<>();
        if (Objects.equals(pulledMapWithValues.get("status"), "added")) {
            result.put("Property '" + pulledMapWithValues.get("key"), "' was added with value: "
                    + changeValue(pulledMapWithValues.get("newValue")) + "\n");
        }
        if (Objects.equals(pulledMapWithValues.get("status"), "deleted")) {
            result.put("Property '" + pulledMapWithValues.get("key"), "' was removed\n");
        }
        if (pulledMapWithValues.get("status").equals("changed")) {
            result.put("Property '" + pulledMapWithValues.get("key"), "' was updated. From "
                    + changeValue(pulledMapWithValues.get("oldValue"))
                    + " to " + changeValue(pulledMapWithValues.get("newValue"))
                    + "\n");
        }
        return result;
    }

    private static String buildString(Map<String, Object> pulledMapWithValues) {
        return  pulledMapWithValues.keySet().stream()
                .sorted(Comparator.comparing((String key) -> key.substring(10))
                        .thenComparing(key -> "Property ".indexOf(key.charAt(2))))
                .map(value -> value + pulledMapWithValues.get(value))
                .collect(Collectors.joining(""));
    }
}
