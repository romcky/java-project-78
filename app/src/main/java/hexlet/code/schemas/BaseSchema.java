package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {
    protected List<Predicate<T>> checks;

    public BaseSchema() {
        this.checks = new ArrayList<Predicate<T>>();
    }

    public boolean isValid(T obj) {
        return checks.stream().allMatch(check -> obj != null && check.test(obj));
    }
}
