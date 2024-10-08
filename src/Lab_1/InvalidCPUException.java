package Lab_1;

public class InvalidCPUException  extends  Exception{
    public InvalidCPUException(){
        super("Invalid CPU type");
    }
    public InvalidCPUException(String message){
        super("Invalid CPU type: "+ message);
    }
}
