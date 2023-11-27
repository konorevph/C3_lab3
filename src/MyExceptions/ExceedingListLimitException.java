package MyExceptions;

public class ExceedingListLimitException extends RuntimeException{

    public ExceedingListLimitException(String message){
        super(message);
    }
}
