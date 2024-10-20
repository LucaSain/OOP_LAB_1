package Lab_2;

import org.jetbrains.annotations.NotNull;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Account implements Comparable<Account>, Storable{

    public String getIBAN() {
        return IBAN;
    }

    private final String IBAN;
    int amount; //package private

    public Account(int amount, String IBAN) {
        this.amount = amount;
        this.IBAN = IBAN;
    }

    public boolean withdraw(int amount) throws Exception {
        if(amount<=0){
            throw new Exception("Invalid amount!");
        }
        if(amount>this.amount){
            return false;
        }
        this.amount -= amount;
        return true;
    }
    public int deposit(int amount) throws Exception{
        if(amount<=0){
            throw new Exception("Invalid amount!");
        }
        this.amount+=amount;
        return amount;
    }

    @Override
    public int compareTo(@NotNull Account o) {
        return IBAN.compareTo(o.IBAN);
    }

    @Override
    public String toString() {
        return "Account{" +
                "IBAN='" + IBAN + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public void store(String file) {
        try(
                FileOutputStream outputFile=new FileOutputStream(file);

                OutputStreamWriter outputStream=new OutputStreamWriter(outputFile);

                PrintWriter pw=new PrintWriter(outputStream);
        ){
        pw.println(this);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
