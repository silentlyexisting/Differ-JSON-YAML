package hexlet.code.Formatters;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Plain {

    private static Map<String, Object> unpackList(List<Map<String, Object>> pulledValues) {
        Map<String, Object> result = new LinkedHashMap<>();
        for (Map<String, Object> map : pulledValues) {

        }
        return result;
    }

    private static Map<String, Object> changeStatus(Map<String, Object> pulledMapWithValues) {
        Map<String, Object> result = new LinkedHashMap<>();
        if (pulledMapWithValues.get("key").equals("added")) {
            result.put("Property '" + pulledMapWithValues.get("key"), "' was added with value: '" + pulledMapWithValues.get("oldValue"));
        }
        if (pulledMapWithValues.get("key").equals("deleted")) {
            result.put("Property '" + pulledMapWithValues.get("key"), "' was removed");
        }
        if (pulledMapWithValues.get("key").equals("changed")) {
            result.put("Property '" + pulledMapWithValues.get("key"), "' was updated. " +
                    "From '" + pulledMapWithValues.get("oldValue") + "' to '" + pulledMapWithValues.get("newValue") + "'");
        }
        return result;
    }
}
