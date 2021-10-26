package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.util.*;

public class Parser {
    public static Map<String, Object> parse(String readedFile, String format) throws Exception {
        if (format.endsWith(".json")) {
            ObjectMapper jsonMapper = new ObjectMapper();
            return jsonMapper.readValue(readedFile, Map.class);
        }
        if (format.endsWith(".yaml") || format.endsWith(".yml")) {
            ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
            return yamlMapper.readValue(readedFile, Map.class);
        }
        return new HashMap<>();
    }
}
