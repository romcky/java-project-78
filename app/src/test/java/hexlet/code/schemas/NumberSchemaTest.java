package hexlet.code.schemas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberSchemaTest {
    @Test
    public void test() {
        var numberSchema = new NumberSchema();
        Assertions.assertTrue(numberSchema.isValid(null));
        numberSchema.positive();
        Assertions.assertTrue(numberSchema.isValid(null));
        numberSchema.required();
        Assertions.assertFalse(numberSchema.isValid(null));
        Assertions.assertTrue(numberSchema.isValid(10));
        Assertions.assertFalse(numberSchema.isValid(0));
        Assertions.assertFalse(numberSchema.isValid(-10));
        numberSchema.range(5, 10);
        Assertions.assertTrue(numberSchema.isValid(5));
        Assertions.assertTrue(numberSchema.isValid(10));
        Assertions.assertFalse(numberSchema.isValid(4));
        Assertions.assertFalse(numberSchema.isValid(11));
    }
}
