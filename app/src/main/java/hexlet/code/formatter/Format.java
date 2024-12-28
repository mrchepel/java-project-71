package hexlet.code.formatter;

import hexlet.code.Node;

import java.util.TreeMap;

public interface Format {
    String generate(TreeMap<String, Node> node);
}
