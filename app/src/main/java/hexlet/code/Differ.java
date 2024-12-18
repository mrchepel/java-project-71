package hexlet.code;

import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        var data1 = Parser.parse(filepath1);
        var data2 = Parser.parse(filepath2);

        Set<String> allKeys = new TreeSet<>();

        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());

        StringBuilder stringBuilder = new StringBuilder("{\n");

        for (var key: allKeys) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);
            if (!data1.containsKey(key)) {
                stringBuilder.append(String.format("  + %s: %s\n", key, value2));
            } else if (!data2.containsKey(key)) {
                stringBuilder.append(String.format("  - %s: %s\n", key, value1));
            } else if (Objects.equals(value1, value2)) {
                stringBuilder.append(String.format("    %s: %s\n", key, value1));
            } else {
                stringBuilder.append(String.format("  - %s: %s\n", key, value1));
                stringBuilder.append(String.format("  + %s: %s\n", key, value2));
            }
        }
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
