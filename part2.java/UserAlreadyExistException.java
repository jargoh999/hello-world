package services.Exceptions;

public class UserAlreadyExistException extends NullPointerException{
    public UserAlreadyExistException(String message){
         super(message);
    }
}
