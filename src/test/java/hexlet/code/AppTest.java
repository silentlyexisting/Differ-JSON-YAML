package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class AppTest {
    private final Path flatJsonPath = Path.of(getFixturesPath("stylishExpected"));
    private final String stylishExpected = readData(flatJsonPath);

    private final Path recursivePath = Path.of(getFixturesPath("recursiveExpected"));
    private final String recursiveExpected = readData(recursivePath);

    private final Path plainPath = Path.of(getFixturesPath("plainExpected"));
    private final String plainExpected = readData(plainPath);

    private final Path jsonPath = Path.of(getFixturesPath("jsonExpected.json"));
    private final String jsonExpected = readData(jsonPath);

    private final Path jsonRecursivePath = Path.of(getFixturesPath("jsonRecursiveExpected.json"));
    private final String jsonRecursiveExpected = readData(jsonRecursivePath);

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

    private static String readData(Path path) throws IOException {
        return Files.readString(path);
    }
}