package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Number> {

    private boolean requiredFlag;

    public NumberSchema required() {
        requiredFlag = true;
        return this;
    }

    public NumberSchema positive() {
        checks.add(num -> num.doubleValue() > .0);
        return this;
    }

    public NumberSchema range(Number min, Number max) {
        checks.add(num -> num.doubleValue() >= min.doubleValue()
                && num.doubleValue() <= max.doubleValue());
        return this;
    }

    @Override
    public boolean isValid(Number num) {
        return !requiredFlag || super.isValid(num);
    }

}
