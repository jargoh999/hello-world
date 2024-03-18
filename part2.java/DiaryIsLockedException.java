package services.Exceptions;

public class DiaryIsLockedException extends  NullPointerException {
      public DiaryIsLockedException(String message){
              super(message);
      }

}
