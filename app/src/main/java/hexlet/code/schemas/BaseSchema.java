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

    public abstract T getTypedObject(Object obj);

    public boolean isValid(Object obj) {
        if (!required) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return checks.stream().allMatch(check -> check.test(getTypedObject(obj)));
    }

    public void setRequired() {
        required = true;
//        checks.add(0, obj -> obj != null);
    }
}
