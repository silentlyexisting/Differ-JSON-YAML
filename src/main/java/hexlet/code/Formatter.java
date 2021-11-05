package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(String format, List<Map<String, Object>> diff) throws Exception {
        switch (format) {
            case "stylish" : return Stylish.genStylishFormat(diff);
            case "plain" : return Plain.genPlainFormat(diff);
            case "json" : return Json.buildJsonFormat(diff);
            default:
                throw new Exception("Invalid format");
        }
    }
}
