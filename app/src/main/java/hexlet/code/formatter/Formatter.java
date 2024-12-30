package hexlet.code.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.Node;

import java.util.Map;
import java.util.TreeMap;

import static hexlet.code.formatter.JsonFormat.JSON;
import static hexlet.code.formatter.PlainFormat.PLAIN;
import static hexlet.code.formatter.StylishFormat.STYLISH;

public class Formatter {
    private static final Map<String, Format> FORMATS = Map.of(
            STYLISH, new StylishFormat(),
            PLAIN, new PlainFormat(),
            JSON, new JsonFormat()
    );

    public static String format(TreeMap<String, Node> diffData, String format) throws JsonProcessingException {
        return FORMATS.get(format).generate(diffData);
    }

}
