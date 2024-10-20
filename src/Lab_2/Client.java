package Lab_2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Client implements Storable{
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

    void removeAccount(String IBAN){
        accounts.removeIf(account -> account.getIBAN().equals(IBAN));
    }

    @Override
    public void store(String file) {
        for(Account account : accounts){
            account.store(file);
        }
    }
}
