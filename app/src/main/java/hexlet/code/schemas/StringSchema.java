package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

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
}
