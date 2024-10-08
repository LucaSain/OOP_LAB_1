package Lab_1;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Bucuresti",23,"Savenilor");
        Client c = new Client(address,"Luca SAINENCO",  LocalDate.now(),"12341413323");
        c.addAccount(new CreditAccount(33,"123213123",222));
        c.removeAccount("123213123");

        try {
            Computer computer = new Computer(8, "i7");
            SoftwareProduct softwareProduct = new SoftwareProduct("MacroHard OnFire","Windaus", 3,"i7");
            computer.addProduct(softwareProduct);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

    }
}