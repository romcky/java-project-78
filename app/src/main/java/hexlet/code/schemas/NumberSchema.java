package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {


    public NumberSchema required() {
        setRequired();
        return this;
    }

    public NumberSchema positive() {
        addCheck(num -> num > 0);
        return this;
    }

    public NumberSchema range(Integer min, Integer max) {
        addCheck(num -> num >= min && num <= max);
        return this;
    }

    @Override
    public boolean isValid(Object object) {
        if (object instanceof Integer) {
            return runAllChecks((Integer)object);
        }
        return false;
    }
}
