package hexlet.code.formatter;

import hexlet.code.Node;

import java.util.Map;
import java.util.TreeMap;

import static hexlet.code.formatter.PlainFormat.PLAIN;
import static hexlet.code.formatter.StylishFormat.STYLISH;

public class Formatter {
    public static Map<String, Format> formats = Map.of(
            STYLISH, new StylishFormat(),
            PLAIN, new PlainFormat()
    );

    public static String format(TreeMap<String, Node> diffData, String format) {
        return formats.get(format).generate(diffData);
    }

}
