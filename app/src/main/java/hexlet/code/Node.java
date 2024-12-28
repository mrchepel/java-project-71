package hexlet.code;

public final class Node {
    public Node(OperationType type, Object oldValue, Object newValue) {
        this.type = type;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public OperationType getType() {
        return type;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    private final OperationType type;
    private final Object oldValue;
    private final Object newValue;
}
