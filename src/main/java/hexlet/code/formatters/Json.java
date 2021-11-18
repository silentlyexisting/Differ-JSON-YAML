package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Json {
    public static String buildJsonFormat(List<Map<String, Object>> diff) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n" + "  \"diffs\": [\n");
        for (Map<String, Object> map : diff) {
            stringBuilder.append("    " + objectMapper.writeValueAsString(map) + ",\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append("  ]\n" + "}");
        return stringBuilder.toString();
    }
}
