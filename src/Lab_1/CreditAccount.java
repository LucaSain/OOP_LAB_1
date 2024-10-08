package Lab_1;

public class CreditAccount extends Account{
    private final int maxCredit;

    public CreditAccount(int ammount, String IBAN, int maxCredit) {
        super(ammount, IBAN);
        this.maxCredit = maxCredit;
    }

    public int getAmmount(){
        return ammount;
    }

    @Override
    public boolean withdraw(int ammount) throws Exception{
        if(ammount<=0){
            throw new Exception("Invalid amount!");
        }
        if(ammount>this.ammount || ammount+this.ammount>maxCredit){
            return false;
        }
        this.ammount -= ammount;
        return true;
    };

}
