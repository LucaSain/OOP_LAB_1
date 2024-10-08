package Lab_1_HW;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Loan> loans;

    public Bank() {
        this.loans = new ArrayList<Loan>();
    }

    public void addLoan(Loan l){
        loans.add(l);
    }
    public void removeLoan(Loan l){
        loans.remove(l);
    }
    public Loan[] find(String name){
    //      for(Loan loan: loans){ //can be optimised using Aho-Corasick Algorithm. Ain't going to implement that for now :3
    //            if(loan.getName().equals(name)){
    //                return loan;
    //            }
    //        }
    //      return false

    //      this is awesome
        return (Loan[]) loans.stream()
                .filter(loan ->  loan.getName().equals(name)).toArray();
    }

    public Loan[] find(String name, double minAmount){
        // declarative rocks
        return (Loan[]) loans.stream()
                .filter(loan ->  loan.getName().equals(name))
                .filter(loan -> loan.getAmount()>=minAmount)
                .toArray();
    }

    public void printInFile(String filename) {

        try{
            FileWriter file = new FileWriter(filename);
            for(Loan loan: loans){
                var person = loan.getPerson();
                file.write(loan.getId()+" "+ loan.getAmount()+" "+person.getName()+" " + person.getSurname()+ " " + person.getSurname() + " " + person.getCNP());
            }
            file.close();
            System.out.println("Successfully wrote to the file.");
        }catch (IOException e){
            System.out.println(e.toString());
        }

    }


}
