package hexlet.code.schemas;


public class StringSchema extends BaseSchema<String> {
    public boolean isRequired = false;
    private Integer minLength = null;
    private String contain = null;

    public StringSchema required() {
        this.isRequired = true;
        return this;
    }

    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;

    }

    public StringSchema contains(String value) {
        this.contain = value;
        return this;
    }

    @Override
    public boolean isValid(String value) {
        if (value == null || value.isEmpty()) {
            return !isRequired;
        }
        if (minLength != null) {
            return value.length() > minLength;
        }
        if (contain != null) {
            return value.contains(contain);
        }
        return true;
    }

}
