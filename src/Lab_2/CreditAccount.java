package Lab_2;

public class CreditAccount extends Account {
    private final int maxCredit;

    public CreditAccount(int amount, String IBAN, int maxCredit) {
        super(amount, IBAN);
        this.maxCredit = maxCredit;
    }

    public int getAmount(){
        return amount;
    }

    @Override
    public boolean withdraw(int amount) throws Exception{
        if(amount<=0){
            throw new Exception("Invalid amount!");
        }
        if(amount>this.amount || amount+this.amount>maxCredit){
            return false;
        }
        this.amount -= amount;
        return true;
    };

}
