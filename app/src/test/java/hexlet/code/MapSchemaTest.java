package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {
    Validator v = new Validator();
    MapSchema schema1 = v.map();
    MapSchema schema2 = v.map();
    Map<String, BaseSchema<String>> schemas = new HashMap<>();

    @Test
    public void testMapSchema() {
        assertTrue(schema1.isValid(null));

        schema1.required();

        assertFalse(schema1.isValid(null));
        assertTrue(schema1.isValid(new HashMap<>()));
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertTrue(schema1.isValid(data));

        schema1.sizeof(2);

        assertFalse(schema1.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema1.isValid(data));
    }

    @Test
    public void testMapSchemaWithShape() {

        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().minLength(2).required());

        schema2.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(schema2.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(schema2.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertFalse(schema2.isValid(human3));
    }
}
