package Account_and_Bank;

     class InvalidPinException extends RuntimeException {
        public InvalidPinException(String message){
        super(message);
        }
    }
class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException(String message){
        super(message);
    }
}



    class AccountNotFoundException extends RuntimeException {

     public AccountNotFoundException(String message){
          super(message);

     }
    }





        class InvalidAmountException extends RuntimeException {
            public InvalidAmountException(String message) {
                super(message);
            }
        }


