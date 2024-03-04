package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {


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
    public Integer getTypedObject(Object object) {
        if (object instanceof Integer) {
            return (Integer) object;
        } else {
            throw new RuntimeException();
        }
    }

}
