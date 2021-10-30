package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String chooseFormat(String format, List<Map<String, Object>> diff) throws Exception {
        if (format.equals("stylish")) {
            return Stylish.genStylishFormat(diff);
        }
        if (format.equals("plain")) {
            return Plain.genPlainFormat(diff);
        }
        if (format.equals("json")) {
            return Json.buildJsonFormat(diff);
        }
        return new String();
    }
}
