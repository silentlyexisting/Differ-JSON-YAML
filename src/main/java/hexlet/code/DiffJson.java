package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiffJson {
    public static Map<String, String> getDiff(Map<String, Object> firstMapa, Map<String, Object> secondMapa) {
        Map<String, String> result = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entry : secondMapa.entrySet()) {
            if (!firstMapa.containsKey(entry.getKey())) {
                result.put(entry.getKey(), "added");
            }
            if (firstMapa.containsKey(entry.getKey()) && !firstMapa.containsValue(entry.getValue())) {
                result.put(entry.getKey(), "changed");
            }
            if (firstMapa.containsKey(entry.getKey()) && firstMapa.containsValue(entry.getValue())) {
                result.put(entry.getKey(), "unchanged");
            }
        }
        for (Map.Entry<String, Object> entry : firstMapa.entrySet()) {
            if (!secondMapa.containsKey(entry.getKey())) {
                result.put(entry.getKey(), "deleted");
            }
        }
        return result;
}

     public static String diffBetweenJsonFiles(Map<String, Object> firstMapa, Map<String, Object> secondMapa) {
        Map<String, String> diff = getDiff(firstMapa, secondMapa);
        String result = "";

        for(Map.Entry<String, String> entry : diff.entrySet()) {
            if(entry.getValue().equals("deleted")) {
                //triple  loop
            }
        }

        return result;
     }
}