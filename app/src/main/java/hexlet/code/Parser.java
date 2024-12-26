package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String filePath) throws Exception {
        ObjectMapper mapper;
        String content = Utils.getTextFromFile(filePath);
        String format = Utils.getFormat(filePath);
        FileType fileType = FileType.valueOf(format.toUpperCase());
        mapper = switch (fileType) {
            case JSON -> new ObjectMapper();
            case YAML, YML -> new YAMLMapper();
        };
        return mapper.readValue(content, new TypeReference<>() {
        });
    }
}
