package Lab_2_HW;

public class TruckDealership extends Dealership{
    @Override
    Vehicle createVehicle() {
        //logic to process the list of truck params
        return new Truck("Anaximander MK1", Country.OTHER,12000);
    }
}
