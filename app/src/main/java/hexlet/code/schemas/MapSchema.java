package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends
        BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        setRequired();
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck(map -> map.size() == size);
        return this;
    }

    @Override
    public boolean isValid(Object object) {
        if (object instanceof Map) {
            return runAllChecks((Map) object);
        }
        return false;
    }


    public <T> MapSchema shape(Map<String, BaseSchema<T>> schema) {
        setRequired();
        addCheck(map -> {
            for (var entry : schema.entrySet()) {
                if (!schema.get(entry.getKey()).isValid(map.get(entry.getKey()))) {
                    return false;
                }
            }
            return true;
        });

        return this;
    }
}
