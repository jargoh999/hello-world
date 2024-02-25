import java.util.NoSuchElementException;

public class NoSuchDiaryException extends NoSuchElementException {
    public NoSuchDiaryException(String message){
        super(message);
    }
}
