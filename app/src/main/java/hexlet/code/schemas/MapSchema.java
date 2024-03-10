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

    @SuppressWarnings("unchecked")
    public <T> MapSchema shape(Map<String, BaseSchema<T>> schema) {
        setRequired();
        addCheck(map -> {
            for (var entry : schema.entrySet()) {
                Object obj = map.get(entry.getKey());
                if (!schema.get(entry.getKey()).isValid((T) obj)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}
