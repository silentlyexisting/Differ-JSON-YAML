package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class AppTest {
    private final Path path =
            Paths.get("src/test/resources/expected/stylishExpected").toAbsolutePath().normalize();
    private final String stylishExpected = Files.readString(path);

    private final Path path2 =
            Paths.get("src/test/resources/expected/recursiveExpected").toAbsolutePath().normalize();
    private final String recursiveExpected = Files.readString(path2);

    private final Path path3 = Paths.get("src/test/resources/expected/plainExpected").toAbsolutePath().normalize();
    private final String plainExpected = Files.readString(path3);

    private final Path path4 =
            Paths.get("src/test/resources/expected/jsonExpected.json").toAbsolutePath().normalize();
    private final String jsonExpected = Files.readString(path4);

    private final Path path5 =
            Paths.get("src/test/resources/expected/jsonRecursiveExpected.json").toAbsolutePath().normalize();
    private final String jsonRecursiveExpected = Files.readString(path5);

    AppTest() throws IOException {
    }

    @Test
    void testStylishJson() throws Exception {
        String firstJson = getFileName("jsonfile1.json");
        String secondJson = getFileName("jsonfile2.json");
        String actual = Differ.generate(getFixturesPath(firstJson), getFixturesPath(secondJson));
        String expected = stylishExpected;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testStylishYaml() throws Exception {
        String firstYaml = getFileName("yamlfile1.yaml");
        String secondYaml = getFileName("yamlfile2.yaml");
        String actual = Differ.generate(getFixturesPath(firstYaml), getFixturesPath(secondYaml));
        String expected = stylishExpected;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testRecursive() throws Exception {
        String firstJson = getFileName("jsonRecursiveFile1.json");
        String secondJson = getFileName("jsonRecursiveFile2.json");
        String actual = Differ.generate(getFixturesPath(firstJson), getFixturesPath(secondJson));
        String expected = recursiveExpected;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testPlain() throws Exception {
        String firstJson = getFileName("jsonRecursiveFile1.json");
        String secondJson = getFileName("jsonRecursiveFile2.json");
        String actual = Differ.generate(getFixturesPath(firstJson), getFixturesPath(secondJson), "plain");
        String expected = plainExpected;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testJson() throws Exception {
        String firstJson = getFileName("jsonfile1.json");
        String secondJson = getFileName("jsonfile2.json");
        String actaul = Differ.generate(getFixturesPath(firstJson), getFixturesPath(secondJson), "json");
        String expected = jsonExpected;
        Assertions.assertEquals(expected, actaul);
    }

    @Test
    void testJsonRecursive() throws Exception {
        String firstJson = getFileName("jsonRecursiveFile1.json");
        String secondJson = getFileName("jsonRecursiveFile2.json");
        String actual = Differ.generate(getFixturesPath(firstJson), getFixturesPath(secondJson), "json");
        String expected = jsonRecursiveExpected;
        Assertions.assertEquals(expected, actual);
    }

    private static String getFixturesPath(String fileName) {
        return "src/test/resources/fixtures/" + fileName;
    }

    private static String getFileName(String fileName) {
        return fileName;
    }
}
