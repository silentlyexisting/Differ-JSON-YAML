package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    private Path path = Paths.get("src/test/resources/jsonexpected").toAbsolutePath().normalize();
    private final String file = Files.readString(path);

    AppTest() throws IOException {
    }

    @Test
    void getTest() throws Exception {
        String readedFile1 = "src/test/resources/fixtures/jsonfile1.json";
        String readedFile2 = "src/test/resources/fixtures/jsonfile2.json";
        String actual = Differ.generate(readedFile1, readedFile2);

        String expected = file;
        Assertions.assertEquals(expected, actual);
    }

}