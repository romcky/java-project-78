package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends
        BaseSchema<Map<String, ?>> {

    public MapSchema required() {
        setRequired();
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck(map -> map.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<?>> schema) {
        addCheck(map -> {
            for (var entry : schema.entrySet()) {
                // у нас мама со свойствами разных типов (String, String/Number)
                // и мапа валидцаии с валидаторами разных типов (String, String/Number)
                // как их совмесить чтоб пройти проверку типов?
                if (!schema.get(entry.getKey()).isValid(map.get(entry.getKey()))) {
                    return false;
                }
            }
            return true;
        });

        return this;
    }
}
