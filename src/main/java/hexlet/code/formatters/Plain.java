package hexlet.code.formatters;


import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Arrays;
import java.util.Comparator;

public class Plain {
    private static final int SPACE = 10;
    public static String genPlainFormat(List<Map<String, Object>> pulledValues) {
        Map<String, Object> tempMap = unpackList(pulledValues);
        String result = buildAnswer(tempMap);
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
        if (Objects.equals(pulledMapWithValues.get("status"), "changed")) {
            result.put("Property '" + pulledMapWithValues.get("key"), "' was updated. From "
                    + changeValue(pulledMapWithValues.get("oldValue"))
                    + " to " + changeValue(pulledMapWithValues.get("newValue"))
                    + "\n");
        }
        return result;
    }

    private static String buildAnswer(Map<String, Object> pulledMapWithValues) {
        return  pulledMapWithValues.keySet().stream()
                .sorted(Comparator.comparing((String key) -> key.substring(SPACE))
                        .thenComparing(key -> "Property ".indexOf(key.charAt(2))))
                .map(value -> value + pulledMapWithValues.get(value))
                .collect(Collectors.joining(""));
    }
}
