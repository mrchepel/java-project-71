package hexlet.code.formatter;

import hexlet.code.Node;
import hexlet.code.OperationType;

import java.util.TreeMap;

public class StylishFormat {
    private static final String PLUS = "  + ";
    private static final String MINUS = "  - ";
    private static final String NO_CHANGES = "    ";

    public String generate(TreeMap<String, Node> diffData) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        diffData.forEach((key, node) -> {
            OperationType type = node.getType();
            Object oldValue = node.getOldValue();
            Object newValue = node.getNewValue();

            switch (type) {
                case OperationType.ADDED -> appendChange(sb, PLUS, key, newValue);
                case OperationType.DELETED -> appendChange(sb, MINUS, key, oldValue);
                case OperationType.UNCHANGED -> appendChange(sb, NO_CHANGES, key, newValue);
                case OperationType.UPDATED -> {
                    appendChange(sb, MINUS, key, oldValue);
                    appendChange(sb, PLUS, key, newValue);
                }
                default -> {
                }
            }
        });
        sb.append("}");

        return sb.toString();
    }

    private static void appendChange(StringBuilder sb, String prefix, String key, Object value) {
        sb.append(prefix).append(key).append(": ").append(value).append("\n");
    }
}
