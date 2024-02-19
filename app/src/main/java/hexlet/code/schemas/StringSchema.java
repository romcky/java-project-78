package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringSchema {
    List<Predicate<String>> checks;

    public StringSchema() {
        this.checks = new ArrayList<>();
    }

    public StringSchema required() {
        checks.add(str -> !str.isEmpty());
        return this;
    }

    public StringSchema minLength(int len) {
        checks.add(str -> str.length() >= len);
        return this;
    }

    public StringSchema contains(String substr) {
        checks.add(str -> str.contains(substr));
        return this;
    }

    public boolean isValid(String str) {
        if (checks.isEmpty()) {
            return true;
        } else {
            return str != null && checks.stream().allMatch(check -> check.test(str));
        }
    }
}
