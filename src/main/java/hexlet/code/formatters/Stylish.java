package hexlet.code.formatters;


import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Comparator;

public class Stylish {
    private static final int SPACE = 4;
    public static String genStylishFormat(List<Map<String, Object>> diff) {
        Map<String, Object> statesToNode = unpack(diff);
        return buildAnswer(statesToNode);
    }

    private static Map<String, Object> unpack(List<Map<String, Object>> diff) {
        Map<String, Object> unpackedValues = new LinkedHashMap<>();
        for (Map<String, Object> map : diff) {
            unpackedValues.putAll(changeStatus(map));
        }
        return unpackedValues;
    }

    private static Map<String, Object> changeStatus(Map<String, Object> diff) {
        Map<String, Object> result = new LinkedHashMap<>();
        if (diff.get("status").equals("added")) {
            result.put("  + " + diff.get("key") + ": ", diff.get("oldValue") + "\n");
        }
        if (diff.get("status").equals("deleted")) {
            result.put("  - " + diff.get("key") + ": ", diff.get("oldValue") + "\n");
        }
        if (diff.get("status").equals("changed")) {
            result.put("  - " + diff.get("key") + ": ", diff.get("oldValue") + "\n");
            result.put("  + " + diff.get("key") + ": ", diff.get("newValue") + "\n");
        }
        if (diff.get("status").equals("unchanged")) {
            result.put("    " + diff.get("key") + ": ", diff.get("oldValue") + "\n");
        }
        return result;
    }

    private static String buildAnswer(Map<String, Object> diff) {
        return  diff.keySet().stream()
                .sorted(Comparator.comparing((String key) -> key.substring(SPACE))
                        .thenComparing(key -> " -+".indexOf(key.charAt(2))))
                .map(value -> value + diff.get(value))
                .collect(Collectors.joining("", "{\n", "}"));
    }
}
