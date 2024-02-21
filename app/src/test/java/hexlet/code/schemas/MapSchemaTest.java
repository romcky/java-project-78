package hexlet.code.schemas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class MapSchemaTest {

    @Test
    public void test() {
        var mapSchema = new MapSchema();
        Assertions.assertTrue(mapSchema.isValid(null));
        mapSchema.required();
        Assertions.assertFalse(mapSchema.isValid(null));
        Assertions.assertTrue(mapSchema.isValid(new HashMap<>()));
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        Assertions.assertTrue(mapSchema.isValid(data));
        mapSchema.sizeof(2);
        Assertions.assertFalse(mapSchema.isValid(data));
        data.put("key2", "value2");
        Assertions.assertTrue(mapSchema.isValid(data));
    }
}
