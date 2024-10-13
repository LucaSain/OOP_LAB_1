package Lab_2_HW;

public abstract class Vehicle implements Taxable, Comparable<Vehicle>{
    private final double CUSTOM_TAX;
    private final double ROAD_TAX;
    private final String name;
    private final double basePrice;
    private final Country country;
    private final VehicleType vehicleType;

    @Override
    public String toString() {
        return name;
    }


    //a Method Factory could have been used here.
    public Vehicle(String name, Country country, VehicleType vehicleType, double basePrice) {
        // can be converted to local variable
        this.country=country;
        this.CUSTOM_TAX = country.customTax;

        this.vehicleType = vehicleType;
        this.ROAD_TAX = vehicleType.roadTax;

        this.basePrice = basePrice;
        this.name = name;
    }

    @Override
    public double computeVAT() {
        return basePrice*VAT;
    }

    @Override
    public double computeRoadTax() {
        return basePrice*ROAD_TAX;
    }

    @Override
    public double computeCustomTax() {
        return basePrice*CUSTOM_TAX;
    }

    @Override
    public double computeTotalTax() {
        return basePrice*(VAT+ROAD_TAX+CUSTOM_TAX);
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public abstract void assemble();

    @Override
    public int compareTo(Vehicle o) {
        if(this.equals(o)){
            return 0;
        }
        return (int) (this.computeTotalTax() - o.computeTotalTax());
    }
}
