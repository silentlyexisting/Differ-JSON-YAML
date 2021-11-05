package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.util.Map;
import java.util.HashMap;


public class Parser {
    private static final String JSON = ".json";
    private static final String YAML = ".yaml";
    public static Map<String, Object> parse(String readedFile, String format) throws Exception {
        if (format.endsWith(JSON)) {
            ObjectMapper objectMapper = createMapperFor(JSON);
            return objectMapper.readValue(readedFile, Map.class);
        }
        if (format.endsWith(YAML) || format.endsWith(".yml")) {
            ObjectMapper objectMapper = createMapperFor(YAML);
            return objectMapper.readValue(readedFile, Map.class);
        }
        return new HashMap<>();
    }

    private static ObjectMapper createMapperFor(String format) throws Exception {
        switch (format) {
            case JSON : return new ObjectMapper();
            case YAML : return new ObjectMapper(new YAMLFactory());
            default:
                throw new Exception("Invalid format");
        }
    }
}
