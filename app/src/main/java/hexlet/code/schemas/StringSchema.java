package hexlet.code.schemas;


public class StringSchema {
    public boolean required = false;
    private int minLength = 0;
    private String contain = null;

    public StringSchema required() {
        this.required = true;
        return this;
    }

    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;

    }

    public StringSchema contains(String value) {
        this.contain = contain;
        return this;
    }

    public boolean isValid(String value) {
        if (required && (value == null || value.isEmpty())) {
            return false;
        }
        if (minLength != 0 && value != null && (value.length() < minLength)) {
            return false;
        }
        if (contain != null && value != null && !value.contains(contain)) {
            return false;
        }
        return true;
    }

}
