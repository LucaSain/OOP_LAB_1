package Lab_2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Bucuresti",23,"Savenilor");
        Client c = new Client(address,"Luca SAINENCO",  LocalDate.now(),"12341413323");
        c.addAccount(new CreditAccount(33,"123213123",222));
        c.store("main.txt");
        c.removeAccount("123213123");
    }
}