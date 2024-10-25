package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {
    public List<Predicate<T>> rules = new ArrayList<>();
    public boolean isRequired = false;

    public boolean isValid(T value) {
        if (value == null || value.toString().isEmpty()) {
            return !isRequired;
        }
        for (var rule : rules) {
            if (!rule.test(value)) {
                return false;
            }
        }
        return true;
    }

}
