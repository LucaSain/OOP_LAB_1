package Lab_1;

public class InvalidRamException extends Exception{
    public InvalidRamException(){
        super("Invalid Ram!");
    }
    public InvalidRamException(String message){
        super("Invalid Ram!:" + message);
    }

}
