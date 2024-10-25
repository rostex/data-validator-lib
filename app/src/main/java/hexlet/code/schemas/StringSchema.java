package hexlet.code.schemas;


public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        super.isRequired = true;
        return this;
    }

    public StringSchema minLength(int lengthValue) {
        super.rules.clear();
        super.rules.add(string -> string.length() >= lengthValue);
        return this;
    }

    public StringSchema contains(String value) {
        super.rules.add(string -> string.contains(value));
        return this;
    }

}
