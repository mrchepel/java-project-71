package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DifferTest {
    private static String expected;

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath, StandardCharsets.UTF_8).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        expected = readFixture("result.txt");
    }

    @Test
    void testDiffer() throws Exception {
        var path1 = getFixturePath("file1.json");
        var path2 = getFixturePath("file2.json");
        String actual = Differ.generate(path1.toString(), path2.toString());
        assertEquals(expected, actual);
    }
}
