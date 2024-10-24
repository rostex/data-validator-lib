package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, String>> {
    public boolean isRequired = false;
    private Integer size = null;
    private Map<String, BaseSchema<String>> schemas;

    public MapSchema required() {
        this.isRequired = true;
        return this;
    }

    public MapSchema sizeof(int sizeValue) {
        this.size = sizeValue;
        return this;

    }

    public MapSchema shape(Map<String, BaseSchema<String>> mapSchemas) {
        this.schemas = mapSchemas;
        return this;
    }

    @Override
    public boolean isValid(Map<String, String> map) {
        if (map == null) {
            return !isRequired;
        }
        if (map.isEmpty()) {
            return isRequired;
        }
        if (size != null && map.size() < size) {
            return false;
        }
        if (schemas == null) {
            return true;
        }
        for (var entry : map.entrySet()) {
            var schemaKey = schemas.get(entry.getKey());
            if (entry.getValue() == null) {
                return false;
            }
            if (schemaKey != null && !schemaKey.isValid(entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
