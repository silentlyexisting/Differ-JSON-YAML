package hexlet.code.formatters;


import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Comparator;

public class Stylish {
    private static final int SPACE = 4;
    public static String genStylishFormat(List<Map<String, Object>> pulledValues) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Object> tempMap = unpackList(pulledValues);
        stringBuilder.append("{\n").append(buildAnswer(tempMap)).append("}");
        return stringBuilder.toString();
    }

    private static Map<String, Object> unpackList(List<Map<String, Object>> pulledValues) {
        Map<String, Object> unpackedValues = new LinkedHashMap<>();
        for (Map<String, Object> map : pulledValues) {
            unpackedValues.putAll(changeStatus(map));
        }
        return unpackedValues;
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

    private static String buildAnswer(Map<String, Object> pulledMapWithValues) {
        return  pulledMapWithValues.keySet().stream()
                .sorted(Comparator.comparing((String key) -> key.substring(SPACE))
                        .thenComparing(key -> " -+".indexOf(key.charAt(2))))
                .map(value -> value + pulledMapWithValues.get(value))
                .collect(Collectors.joining(""));
    }
}
