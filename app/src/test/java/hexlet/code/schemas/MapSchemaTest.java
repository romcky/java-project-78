package hexlet.code.schemas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class MapSchemaTest {

    @Test
    public void test() {
        var mapSchema = new MapSchema();
        Assertions.assertTrue(mapSchema.runAllChecks(null));
        mapSchema.required();
        Assertions.assertFalse(mapSchema.runAllChecks(null));
        Assertions.assertTrue(mapSchema.runAllChecks(new HashMap<>()));
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        Assertions.assertTrue(mapSchema.runAllChecks(data));
        mapSchema.sizeof(2);
        Assertions.assertFalse(mapSchema.runAllChecks(data));
        data.put("key2", "value2");
        Assertions.assertTrue(mapSchema.runAllChecks(data));
    }
}
