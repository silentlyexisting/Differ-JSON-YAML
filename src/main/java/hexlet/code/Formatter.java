package hexlet.code;

import hexlet.code.Formatters.Plain;
import hexlet.code.Formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String chooseFormat(String format, List<Map<String, Object>> diff) throws Exception {
        if (format.equals("stylish")) {
            return Stylish.buildString(diff);
        } else if (format.equals("plain")) {
            return Plain.buildResult(diff);
        }
        return new String();
    }
}
