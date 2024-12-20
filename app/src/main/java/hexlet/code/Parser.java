package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static hexlet.code.Utils.getPath;

public class Parser {
    public static Map<String, Object> parse(String filePath) throws Exception {
        Path normalizePath = getPath(filePath);
        String content = new String(Files.readAllBytes(normalizePath));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<>() {
        });
    }
}
