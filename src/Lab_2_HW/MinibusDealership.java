package Lab_2_HW;

public class MinibusDealership extends Dealership{
    @Override
    Vehicle createVehicle() {
        return new Minibus("Xenophanes 12 Pro",Country.OTHER,1337);
    }
}
