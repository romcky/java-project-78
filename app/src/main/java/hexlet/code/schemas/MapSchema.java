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
    public Map<?, ?> getTypedObject(Object obj) {
        if (obj instanceof Map) {
            return (Map) obj;
        } else {
            throw new RuntimeException();
        }
    }

        
    public MapSchema shape(Map<String, BaseSchema<?>> schema) {
        setRequired();
        addCheck(map -> {
            for (var entry : schema.entrySet()) {
                Object obj = map.get(entry.getKey());
                if (!schema.get(entry.getKey()).isValid(obj)) {
                    return false;
                }
            }
            return true;
        });

        return this;
    }
}
