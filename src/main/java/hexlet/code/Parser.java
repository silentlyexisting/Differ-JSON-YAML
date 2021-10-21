package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    public static Map<String, Object> parse(String readedFile) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> path = objectMapper.readValue(readedFile, Map.class);
        return path;
    }
}
