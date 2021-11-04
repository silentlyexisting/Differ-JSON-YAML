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
    public static String genPlainFormat(List<Map<String, Object>> diff) {
        Map<String, Object> tempMap = unpackList(diff);
        return buildAnswer(tempMap);
    }

    private static Map<String, Object> unpackList(List<Map<String, Object>> diff) {
        Map<String, Object> result = new LinkedHashMap<>();
        for (Map<String, Object> map : diff) {
            result.putAll(changeStatus(map));
        }
        return result;
    }

    private static Object stringify(Object value) {
        if (value instanceof  Arrays || value instanceof List || value instanceof Map) {
            return "[complex value]";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        return value;
    }

    private static Map<String, Object> changeStatus(Map<String, Object> diff) {
        Map<String, Object> result = new LinkedHashMap<>();
        if (Objects.equals(diff.get("status"), "added")) {
            result.put("Property '" + diff.get("key"), "' was added with value: "
                    + stringify(diff.get("newValue")));
        }
        if (Objects.equals(diff.get("status"), "deleted")) {
            result.put("Property '" + diff.get("key"), "' was removed");
        }
        if (Objects.equals(diff.get("status"), "changed")) {
            result.put("Property '" + diff.get("key"), "' was updated. From "
                    + stringify(diff.get("oldValue"))
                    + " to " + stringify(diff.get("newValue")));
        }
        return result;
    }

    private static String buildAnswer(Map<String, Object> pulledMapWithValues) {
        return  pulledMapWithValues.keySet().stream()
                .sorted(Comparator.comparing((String key) -> key.substring(SPACE))
                        .thenComparing(key -> "Property ".indexOf(key.charAt(2))))
                .map(value -> value + pulledMapWithValues.get(value))
                .collect(Collectors.joining("\n"));
    }
}
