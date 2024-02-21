package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        setRequired();
        addCheck(str -> !str.isEmpty());
        return this;
    }

    public StringSchema minLength(int len) {
        addCheck(str -> str.length() >= len);
        return this;
    }

    public StringSchema contains(String substr) {
        addCheck(str -> str.contains(substr));
        return this;
    }
}
