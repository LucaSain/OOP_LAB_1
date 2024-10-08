package Lab_1_HW;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Person person = new Person("Ion", "Ionescu","1234412312312");
        Loan loan = new Loan(500.0,person);
        bank.addLoan(loan);
        bank.printInFile("test.txt");
        bank.removeLoan(loan);
        bank.printInFile("test2.txt");
    }
}