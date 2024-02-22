package hexlet.code.schemas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberSchemaTest {
    @Test
    public void test() {
        var numberSchema = new NumberSchema();
        Assertions.assertTrue(numberSchema.runAllChecks(null));
        numberSchema.positive();
        Assertions.assertTrue(numberSchema.runAllChecks(null));
        numberSchema.required();
        Assertions.assertFalse(numberSchema.runAllChecks(null));
        Assertions.assertTrue(numberSchema.runAllChecks(10));
        Assertions.assertFalse(numberSchema.runAllChecks(0));
        Assertions.assertFalse(numberSchema.runAllChecks(-10));
        numberSchema.range(5, 10);
        Assertions.assertTrue(numberSchema.runAllChecks(5));
        Assertions.assertTrue(numberSchema.runAllChecks(10));
        Assertions.assertFalse(numberSchema.runAllChecks(4));
        Assertions.assertFalse(numberSchema.runAllChecks(11));
    }
}
