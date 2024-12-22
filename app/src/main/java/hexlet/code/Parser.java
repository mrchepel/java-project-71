package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static hexlet.code.Utils.getFormat;
import static hexlet.code.Utils.getPath;

public class Parser {
    public static Map<String, Object> parse(String filePath) throws Exception {
        ObjectMapper mapper = null;
        Path normalizePath = getPath(filePath);
        String content = new String(Files.readAllBytes(normalizePath));
        String format = getFormat(filePath);
        FileType fileType = FileType.valueOf(format.toUpperCase());
        switch (fileType) {
            case JSON:
                mapper = new ObjectMapper();
                break;
            case YAML, YML:
                mapper = new YAMLMapper();
                break;
            default:
                break;
        }
        return mapper.readValue(content, new TypeReference<>() {
        });
    }
}
