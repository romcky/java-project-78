package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends
        BaseSchema<Map<? extends Object, ? extends Object>> {

    public MapSchema required() {
        setRequired();
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck(map -> map.size() == size);
        return this;
    }
}
