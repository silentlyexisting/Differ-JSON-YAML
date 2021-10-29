package hexlet.code;

import hexlet.code.Formatters.Plain;
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
        //приводим прочитанные файлы к строке
        String readedFile1 = readFile(filepath1);
        String readedFile2 = readFile(filepath2);
        //
        //парсим строки(файлы приведенные к строке) и приводим их к мапе
        Map<String, Object> mapa1 = Parser.parse(readedFile1, filepath1);
        Map<String, Object> mapa2 = Parser.parse(readedFile2, filepath1);
        //
        //возвращает результат работы метода другого класса, который сравнивает файлы (принимает в аргах - мапы).
        List<Map<String, Object>> diff = DiffJson.getDiff(mapa1, mapa2);
//        return Stylish.buildString(result);
//        return Plain.buildResult(result);
        return Formatter.chooseFormat(format, diff);
    }

    public static String readFile(String filepath) throws IOException {
        //читаем переданные директории/файлы из консоли
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        return Files.readString(path);
    }
}
