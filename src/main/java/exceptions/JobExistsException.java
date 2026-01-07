package exceptions;

public class JobExistsException extends Exception{
    public JobExistsException(String message){
        super(message);
    }
}
