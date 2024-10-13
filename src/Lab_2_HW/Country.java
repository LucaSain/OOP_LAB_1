package Lab_2_HW;

public enum Country {
    RO(0.0, "Romania"),
    OTHER(0.1, "Other");

    public final double customTax;
    public final String valueString;
    Country(double customTax,String valueString) {
        this.customTax = customTax;
        this.valueString = valueString;
    }

    @Override
    public String toString() {
        return valueString;
    }
}
