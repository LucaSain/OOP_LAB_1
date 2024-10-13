package Lab_2_HW;

public enum VehicleType {
    MINIBUS(0.03),
    BUS(0.04),
    TRUCK(0.05);

    public final double roadTax;
    VehicleType(double roadTax) {
        this.roadTax = roadTax;
    }
}
