package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        List<Map<String, Object>> result = DiffJson.getDiff(mapa1, mapa2); //возвращает результат работы метода другого класса, который сравнивает файлы (принимает в аргах - мапы).
        return Stylish.buildString(result);
    }

    private static String readFile(String filepath) throws IOException {
        //читаем переданные директории/файлы из консоли
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        return Files.readString(path);
    }
}
