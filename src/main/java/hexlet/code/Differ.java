package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String firstReadedFile = readFile(filepath1);
        String secondReadedFile = readFile(filepath2);
        // парсим строки(файлы приведенные к строке) и приводим их к мапе
        Map<String, Object> firstMap = Parser.parse(firstReadedFile, filepath1);
        Map<String, Object> secondMap = Parser.parse(secondReadedFile, filepath1);
        List<Map<String, Object>> diff = Diff.genDiff(firstMap, secondMap);
        // genDiff возвращает результат работы метода другого класса, который сравнивает файлы
        return Formatter.format(format, diff);
    }

    public static String readFile(String filepath) throws IOException {
        // читаем переданные директории/файлы из консоли
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        return Files.readString(path);
    }
}
