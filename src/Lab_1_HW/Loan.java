package Lab_1_HW;

public class Loan {
    private static int id=0;
    private double amount;
    private Person person;

    public void increaseAmount(int added) throws Exception{
        if(added < 0){
            throw new Exception("Invalid amount! Amount must be positive!");
        }
        this.amount+=added;
    }

    public Loan(double amount, Person person) {
        id+=1;
        this.amount = amount;
        this.person = person;
    }

    public String getName(){
        return this.person.getName();
    }

    public Person getPerson() {
        return person;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }
}
