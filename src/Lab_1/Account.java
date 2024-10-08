package Lab_1;

public class Account{

    public String getIBAN() {
        return IBAN;
    }

    private String IBAN;
    int ammount; //package private

    public Account(int ammount, String IBAN) {
        this.ammount = ammount;
        this.IBAN = IBAN;
    }



    public boolean withdraw(int ammount) throws Exception {
        if(ammount<=0){
            throw new Exception("Invalid amount!");
        }
        if(ammount>this.ammount){
            return false;
        }
        this.ammount -= ammount;
        return true;
    }
    public int deposit(int ammount) throws Exception{
        if(ammount<=0){
            throw new Exception("Invalid amount!");
        }
        this.ammount+=ammount;
        return ammount;
    }
}
