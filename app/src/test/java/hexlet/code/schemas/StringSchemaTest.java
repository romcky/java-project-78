package hexlet.code.schemas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringSchemaTest {
    @Test
    public void allTest() {
        var stringSchema = new StringSchema();
        Assertions.assertTrue(stringSchema.isValid(null));
        stringSchema.required();
        Assertions.assertFalse(stringSchema.isValid(null));
        Assertions.assertFalse(stringSchema.isValid(""));
        Assertions.assertTrue(stringSchema.isValid("One"));
        stringSchema.minLength(5);
        Assertions.assertFalse(stringSchema.isValid("One"));
        Assertions.assertTrue(stringSchema.isValid("OneAndTwo"));
    }
}
