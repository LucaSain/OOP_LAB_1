package Lab_2_HW;

//Factory Method Creational Pattern
public abstract class Dealership {

    //Observer would be fun here to manage a credit account/
    public Vehicle sellVehicle(){
        Vehicle vehicle = createVehicle();
        vehicle.assemble();
        return vehicle;
    }

    abstract Vehicle createVehicle();
}
