package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private final List<Predicate<T>> checks = new ArrayList<Predicate<T>>();
    private boolean required;

    public void addCheck(Predicate<T> check) {
        checks.add(check);
    }

    public boolean runAllChecks(T obj) {
        return !required || checks.stream().allMatch(check -> check.test(obj));
    }

    abstract boolean isValid(Object obj);

    public void setRequired() {
        required = true;
        checks.add(0, obj -> obj != null);
    }
}
