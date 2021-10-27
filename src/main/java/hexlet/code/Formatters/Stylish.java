package hexlet.code.Formatters;

import java.util.*;
import java.util.stream.Collectors;

public class Stylish {
    public static String buildString(List<Map<String, Object>> pulledMapWithValues) {
        StringBuilder sb = new StringBuilder();
        Map<String, Object> temp = unpackList(pulledMapWithValues);
        sb.append("{\n").append(buildString(temp)).append("}");
        return sb.toString();

    }

    private static Map<String, Object> unpackList(List<Map<String, Object>> pulledMapWithValues) {
        Map<String, Object> result = new LinkedHashMap<>();
        for (Map<String, Object> map : pulledMapWithValues) {
            result.putAll(changeStatus(map));
        }
        return result;
    }

    private static Map<String, Object> changeStatus(Map<String, Object> pulledMapWithValues) {
        Map<String, Object> result = new LinkedHashMap<>();
        if (pulledMapWithValues.get("status").equals("added")) {
            result.put("  + " + pulledMapWithValues.get("key") + ": ", pulledMapWithValues.get("oldValue") + "\n");
        }
        if (pulledMapWithValues.get("status").equals("deleted")) {
            result.put("  - " + pulledMapWithValues.get("key") + ": ", pulledMapWithValues.get("oldValue") + "\n");
        }
        if (pulledMapWithValues.get("status").equals("changed")) {
            result.put("  - " + pulledMapWithValues.get("key") + ": ", pulledMapWithValues.get("oldValue") + "\n");
            result.put("  + " + pulledMapWithValues.get("key") + ": ", pulledMapWithValues.get("newValue") + "\n");
        }
        if (pulledMapWithValues.get("status").equals("unchanged")) {
            result.put("    " + pulledMapWithValues.get("key") + ": ", pulledMapWithValues.get("oldValue") + "\n");
        }
        return result;
    }

    private static String buildString(Map<String, Object> pulledMapWithValues) {
        return  pulledMapWithValues.keySet().stream()
                .sorted(Comparator.comparing((String key) -> key.substring(4))
                        .thenComparing(key -> " -+".indexOf(key.charAt(2))))
                .map(value -> value + pulledMapWithValues.get(value))
                .collect(Collectors.joining(""));
    }
}
