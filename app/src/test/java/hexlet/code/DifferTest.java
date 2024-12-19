package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DifferTest {

    @Test
    void testCompareIdenticalJson() throws Exception {
        String json1 = "{\"key1\":\"value1\",\"key2\":\"value2\"}";
        String json2 = "{\"key1\":\"value1\",\"key2\":\"value2\"}";

        assertTrue(json1.equals(json2));
    }
}
