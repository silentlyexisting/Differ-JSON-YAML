package hexlet.code;

import hexlet.code.Formatters.Json;
import hexlet.code.Formatters.Plain;
import hexlet.code.Formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String chooseFormat(String format, List<Map<String, Object>> diff) throws Exception {
        if (format.equals("stylish")) {
            return Stylish.buildString(diff);
        }
        if (format.equals("plain")) {
            return Plain.buildResult(diff);
        }
        if (format.equals("json")) {
            return Json.buildJsonFormat(diff);
        }
        return new String();
    }
}
