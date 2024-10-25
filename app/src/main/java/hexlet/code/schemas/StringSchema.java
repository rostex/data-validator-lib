package hexlet.code.schemas;


public class StringSchema extends BaseSchema<String> {

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
