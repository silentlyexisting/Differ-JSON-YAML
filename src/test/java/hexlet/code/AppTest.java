package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class AppTest {
    private final Path path = Paths.get("src/test/resources/stylishExpected").toAbsolutePath().normalize();
    private final String file = Files.readString(path);

    private final Path path2 = Paths.get("src/test/resources/recursiveExpected").toAbsolutePath().normalize();
    private final String file2 = Files.readString(path2);

    private final Path path3 = Paths.get("src/test/resources/plainExpected");
    private final String file3 = Files.readString(path3);

    private final Path path4 = Paths.get("src/test/resources/jsonExpected.json");
    private final String file4 = Files.readString(path4);

    private final Path path5 = Paths.get("src/test/resources/jsonRecursiveExpected.json");
    private final String file5 = Files.readString(path5);

    AppTest() throws IOException {

    }

    @Test
    void testStylishJson() throws Exception {
        String readedFile1 = "src/test/resources/fixtures/jsonfile1.json";
        String readedFile2 = "src/test/resources/fixtures/jsonfile2.json";
        String actual = Differ.generate(readedFile1, readedFile2);
        String expected = file;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testStylishYaml() throws Exception {
        String yamlFilePath1 = "src/test/resources/fixtures/yamlfile1.yaml";
        String yamlFilePath2 = "src/test/resources/fixtures/yamlfile2.yaml";
        String actual = Differ.generate(yamlFilePath1, yamlFilePath2);
        String expected = file;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testRecursive() throws Exception {
        String jsonFilePath1 = "src/test/resources/fixtures/jsonRecursiveFile1.json";
        String jsonFilePath2 = "src/test/resources/fixtures/jsonRecursiveFile2.json";
        String actual = Differ.generate(jsonFilePath1, jsonFilePath2);
        String expected = file2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testPlain() throws Exception {
        String jsonFilePath1 = "src/test/resources/fixtures/jsonRecursiveFile1.json";
        String jsonFilePath2 = "src/test/resources/fixtures/jsonRecursiveFile2.json";
        String actual = Differ.generate(jsonFilePath1, jsonFilePath2, "plain");
        String expected = file3;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testJson() throws Exception {
        String jsonFilePath1 = "src/test/resources/fixtures/jsonfile1.json";
        String jsonFilePath2 = "src/test/resources/fixtures/jsonfile2.json";
        String actaul = Differ.generate(jsonFilePath1, jsonFilePath2, "json");
        String expected = file4;
        Assertions.assertEquals(expected, actaul);
    }

    @Test
    void testJsonRecursive() throws Exception {
        String jsonFilePath1 = "src/test/resources/fixtures/jsonRecursiveFile1.json";
        String jsonFilePath2 = "src/test/resources/fixtures/jsonRecursiveFile2.json";
        String actual = Differ.generate(jsonFilePath1, jsonFilePath2, "json");
        String expected = file5;
        Assertions.assertEquals(expected, actual);
    }
}
