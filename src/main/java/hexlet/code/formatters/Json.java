package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Json {
    public static String buildJsonFormat(List<Map<String, Object>> diff) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(diff);
    }
}
