package hexlet.code.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Node;
import hexlet.code.OperationType;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class JsonFormat implements Format {
    public static final String JSON = "json";

    /**
     * @param diffData data differences
     * @return json
     */

    public String generate(TreeMap<String, Node> diffData) throws JsonProcessingException {
        Map<OperationType, List<Node>> nodesByType = new EnumMap<>(OperationType.class);
        ObjectMapper mapper = new ObjectMapper();

        for (OperationType c : OperationType.values()) {
            nodesByType.put(c, new LinkedList<>());
        }

        diffData.forEach((key, node) -> nodesByType.get(node.getType()).add(node));

        return mapper.writeValueAsString(nodesByType);
    }
}
