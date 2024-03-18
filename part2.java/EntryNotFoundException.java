package services.Exceptions;

public class EntryNotFoundException extends NullPointerException{
    public EntryNotFoundException(String message){
          super(message);
    }
}
