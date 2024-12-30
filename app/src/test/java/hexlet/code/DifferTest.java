package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static hexlet.code.Utils.getTextFromFile;
import static org.junit.jupiter.api.Assertions.assertEquals;


class DifferTest {
    private static String expected;
    private static String resultStylish;
    private static String resultPlain;
    private static String resultJson;

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
        resultStylish = readFixture("resultStylish.txt");
        resultPlain = readFixture("resultPlain.txt");
        resultJson = readFixture("resultJson.txt");
    }

    @Test
    void testDifferJson() throws Exception {
        var path1 = getFixturePath("file1.json");
        var path2 = getFixturePath("file2.json");
        String actual = Differ.generate(path1.toString(), path2.toString());
        assertEquals(expected, actual);
    }

    @Test
    void testDifferYaml() throws Exception {
        var path1 = getFixturePath("file1.yaml");
        var path2 = getFixturePath("file2.yaml");
        String actual = Differ.generate(path1.toString(), path2.toString());
        assertEquals(expected, actual);
    }

    @Test
    void testDifferYml() throws Exception {
        var path1 = getFixturePath("file1.yml");
        var path2 = getFixturePath("file2.yml");
        String actual = Differ.generate(path1.toString(), path2.toString());
        assertEquals(expected, actual);
    }

    @Test
    void testDifferJsonStylish() throws Exception {
        var path1 = getFixturePath("file3.json");
        var path2 = getFixturePath("file4.json");
        String actual = Differ.generate(path1.toString(), path2.toString(), "stylish");
        assertEquals(resultStylish, actual);
    }

    @Test
    void testDifferJsonPlain() throws Exception {
        var path1 = getFixturePath("file3.json");
        var path2 = getFixturePath("file4.json");
        String actual = Differ.generate(path1.toString(), path2.toString(), "plain");
        assertEquals(resultPlain, actual);
    }

    @Test
    void testDifferJsonJson() throws Exception {
        var path1 = getFixturePath("file3.json");
        var path2 = getFixturePath("file4.json");
        String actual = Differ.generate(path1.toString(), path2.toString(), "json");
        assertEquals(resultJson, actual);
    }


}
