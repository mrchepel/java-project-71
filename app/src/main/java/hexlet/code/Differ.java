package hexlet.code;

import hexlet.code.formatter.Formatter;

import java.util.TreeMap;
import java.util.Objects;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        var data1 = Parser.parse(filepath1);
        var data2 = Parser.parse(filepath2);

        TreeMap<String, Node> differences = new TreeMap<>();

        data1.forEach((key, value) -> {
            if (data2.containsKey(key)) {
                if (!Objects.equals(value, data2.get(key))) {
                    differences.put(key, new Node(OperationType.UPDATED, value, data2.get(key)));
                } else {
                    differences.put(key, new Node(OperationType.UNCHANGED, value, value));
                }
            } else {
                differences.put(key, new Node(OperationType.DELETED, value, null));
            }
        });

        data2.forEach((key, value) -> {
            if (!data1.containsKey(key)) {
                differences.put(key, new Node(OperationType.ADDED, null, value));
            }
        });

        return Formatter.formatter(differences);
    }

    public static String generate(String path1, String path2) throws Exception {
        return generate(path1, path2, "stylish");
    }
}
