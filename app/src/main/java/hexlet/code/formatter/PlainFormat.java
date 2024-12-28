package hexlet.code.formatter;

import hexlet.code.Node;
import hexlet.code.OperationType;
import hexlet.code.Utils;

import java.util.TreeMap;

public class PlainFormat implements Format {
    private static final String COMPLEX_VALUE = "[complex value]";
    private static final String PROPERTY = "Property '";
    public static final String PLAIN = "plain";

    /**
     * @param diffData data differences
     * @return text format plain
     */

    public String generate(TreeMap<String, Node> diffData) throws IllegalStateException {
        StringBuilder builder = new StringBuilder();
        diffData.forEach((key, node) -> {
            OperationType type = node.getType();
            Object oldValue = Utils.isComplexValue(node.getOldValue()) ? COMPLEX_VALUE : node.getOldValue();
            Object newValue = Utils.isComplexValue(node.getNewValue()) ? COMPLEX_VALUE : node.getNewValue();

            switch (type) {
                case OperationType.ADDED -> appendAdded(builder, key, newValue);
                case OperationType.DELETED -> appendDeleted(builder, key);
                case OperationType.UPDATED -> appendUpdated(builder, key, newValue, oldValue);
                case OperationType.UNCHANGED -> {
                }
                default -> throw new IllegalStateException("Unexpected value: " + type);
            }

            if (diffData.headMap(key).size() + 1 != diffData.size() && type != OperationType.UNCHANGED) {
                builder.append("\n");
            }
        });

        return builder.toString();
    }

    private static void appendAdded(StringBuilder builder, String key, Object newValue) {
        builder.append(PROPERTY).append(key).append("' was added with value: ");
        appendValueWithQuotesIfNeeded(builder, newValue);
    }

    private static void appendDeleted(StringBuilder builder, String key) {
        builder.append(PROPERTY).append(key).append("' was removed");
    }

    private static void appendUpdated(StringBuilder builder, String key, Object newValue, Object oldValue) {
        builder.append(PROPERTY).append(key).append("' was updated. From ");
        appendValueWithQuotesIfNeeded(builder, oldValue);
        builder.append(" to ");
        appendValueWithQuotesIfNeeded(builder, newValue);
    }

    public static void appendValueWithQuotesIfNeeded(StringBuilder builder, Object value) {
        if (value instanceof String && !value.equals("[complex value]")) {
            builder.append("'").append(value).append("'");
        } else {
            builder.append(value);
        }
    }
}
