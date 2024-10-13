package Lab_2_HW;

public class Truck extends Vehicle{
    public Truck(String name, Country country, double basePrice) {
        super(name, country, VehicleType.TRUCK, basePrice);
    }

    @Override
    public void assemble() {
        //code here
    }
}
