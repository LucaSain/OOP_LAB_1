package Lab_1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Client {
    private ArrayList<Account> accounts;
    private Address address;
    private String name;
    private LocalDate bday;
    private String cnp;

    public Client(Address address, String name, LocalDate bday, String cnp) {
        this.address = address;
        this.accounts = new ArrayList<Account>();
        this.name = name;
        this.bday = bday;
        this.cnp = cnp;
    }

    void addAccount(Account a){
        accounts.add(a);
    }

    boolean removeAccount(String IBAN){
      return accounts.removeIf(account -> account.getIBAN().equals(IBAN));
    }
}
