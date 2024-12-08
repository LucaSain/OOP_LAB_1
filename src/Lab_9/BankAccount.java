package Lab_9;

public class BankAccount {
    private int total;
    BankAccount(){
        this.total =0;
    }
    public synchronized int withDraw(int amount){
        if(amount>total){
            throw new IllegalArgumentException();
        }
        total-=amount;
        System.out.println(Thread.currentThread().getName()+' '+ total);
        return total;
    }

    public synchronized int deposit(int amount){
        total+=amount;
        System.out.println(Thread.currentThread().getName()+' '+ total);
        return total;
    }
}
