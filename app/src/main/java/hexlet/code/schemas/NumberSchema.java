package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer>{
    public boolean isRequired = false;
    private boolean isPositive = false;
    private Integer startNumber = null;
    private Integer endNumber = null;

    public NumberSchema required() {
        this.isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        this.isPositive = true;
        return this;

    }

    public NumberSchema range(int startNumber, int endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        return this;
    }


    @Override
    public boolean isValid(Integer number) {
        if (number == null) {
            return !isRequired;
        }
        if (number <= 0) {
            return !isPositive;
        }
        return (startNumber == null || number >= startNumber)
                && (endNumber == null || number <= endNumber);
    }
}
