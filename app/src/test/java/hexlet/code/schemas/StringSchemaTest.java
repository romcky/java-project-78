package hexlet.code.schemas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringSchemaTest {
    @Test
    public void test() {
        var stringSchema = new StringSchema();
        Assertions.assertTrue(stringSchema.runAllChecks(null));
        stringSchema.required();
        Assertions.assertFalse(stringSchema.runAllChecks(null));
        Assertions.assertFalse(stringSchema.runAllChecks(""));
        Assertions.assertTrue(stringSchema.runAllChecks("One"));
        stringSchema.minLength(5);
        Assertions.assertFalse(stringSchema.runAllChecks("One"));
        Assertions.assertTrue(stringSchema.runAllChecks("OneAndTwo"));
    }
}
