package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.util.Map;

public class Parser {

    public static Map<String, Object>  parse(String fileFormat, String readedFile) throws Exception {
        return createMapperFor(fileFormat).readValue(readedFile, Map.class);
    }

    private static ObjectMapper createMapperFor(String format) throws Exception {
        switch (format) {
            case ".json" : return new ObjectMapper();
            case ".yaml" : return new ObjectMapper(new YAMLFactory());
            default:
                throw new Exception("Invalid format");
        }
    }
}
