package hexlet.code.Formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Json {
    public static String buildJsonFormat(List<Map<String, Object>> pulledListWithMaps) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        stringBuilder.append("  \"diffs\": [\n");
        for (Map<String, Object> map : pulledListWithMaps) {
            stringBuilder.append("    " + objectMapper.writeValueAsString(map) + ",\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append("  ]\n}");
        return stringBuilder.toString();
    }
}
