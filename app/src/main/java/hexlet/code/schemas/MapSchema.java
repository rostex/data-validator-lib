package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, String>> {

    public MapSchema sizeof(int sizeValue) {
        super.rules.add(map -> map.size() >= sizeValue);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> mapSchemas) {
        super.rules.add(map ->
                mapSchemas.entrySet().stream()
                        .allMatch(entry -> {
                            String key = entry.getKey();
                            BaseSchema<String> schema = entry.getValue();
                            String value = map.get(key);
                            return schema.isValid(value);
                        })
        );
        return this;
    }
}
