package Lab_2_HW;

import java.util.Arrays;

public class TestEx2 implements Testable{
    @Override
    public void testAll(){
        Dealership busDealership = new BusDealership();
        Dealership minibusDealership = new MinibusDealership();
        Dealership truckDealership = new TruckDealership();

        //problem: createVehicle is still visible.
        //need to recheck on that

        Vehicle bus = busDealership.sellVehicle();
        Vehicle minibus = minibusDealership.sellVehicle();
        Vehicle truck = truckDealership.sellVehicle();

        Vehicle[] vehicles = {bus,minibus,truck};
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle.getVehicleType());
            System.out.println(vehicle.getName());
            System.out.println(vehicle.getCountry());
            System.out.println(vehicle.getBasePrice());
            System.out.println(vehicle.computeTotalTax());
            System.out.println("------------------------------------");
        }

        Arrays.sort(vehicles);
        for(Vehicle vehicle:vehicles){
            System.out.println(vehicle.getName());
        }
    }
}
