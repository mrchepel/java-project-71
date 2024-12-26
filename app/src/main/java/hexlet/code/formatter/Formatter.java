package hexlet.code.formatter;

import hexlet.code.Node;

import java.util.TreeMap;

public class Formatter {
    public static String formatter(TreeMap<String, Node> diffData) {
        return new StylishFormat().generate(diffData);
    }
}
