package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected List<Predicate<T>> rules = new ArrayList<>();
    protected boolean isRequired = false;

    public final boolean isValid(T value) {
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
