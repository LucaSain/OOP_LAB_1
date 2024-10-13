package Lab_2_HW;

public class BusDealership extends Dealership{

    @Override
    Vehicle createVehicle() {
        return new Bus("Anaximenes A31 Lite",Country.RO,200000);
    }
}
