package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema positive() {
        super.rules.add(number -> number > 0);
        return this;
    }

    public NumberSchema range(int startNumberValue, int endNumberValue) {
        super.rules.add(number -> number >= startNumberValue && number <= endNumberValue);
        return this;
    }

}
