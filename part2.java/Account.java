package Account_and_Bank;
public class Account {



    private String name;
    private int balance;
    private String pin;
    private  Long number ;

    public Account(String firstName,String secondName, String pin , Long accountNumber){
                    this.pin = pin;
                    this.number = accountNumber;
    }

    public Account(String firstName, String lastName,String pin) {
        this.name = firstName + " " + lastName;
        this.pin = pin;
    }

    public Account(Long accountNumber){
        this(null,null,null,accountNumber);
    }
    public void deposit(int amountToBeDeposited){
        if (isValid(amountToBeDeposited)) balance += amountToBeDeposited;
        if (!(isValid(amountToBeDeposited))) throw new InvalidAmountException("invalid amount to deposit");
    }

    public void withdraw(int amountToBeWithdrawn, String userPin) {
        if (isValid(userPin, amountToBeWithdrawn)) balance -= amountToBeWithdrawn;
    }

    public void setPin(String userPin){
        if (isValid(userPin)) this.pin = userPin;
        if (!isValid(userPin)) throw new InvalidPinException("enter a valid pin");
    }

    public String getPin() {
        return pin;
    }

    public int checkBalance() {
        return balance;
    }

    private boolean isValid(int amount) {
        return amount > 0;
    }

    private boolean isValid(String pin) throws InvalidPinException {
        if (!pin.isEmpty() && pin.length() <= 4) return true;
        throw new InvalidPinException("incorrect pin , please re-enter pin");
    }

    private boolean isValid(String userPin, int amountToBeWithdrawn) throws InvalidPinException, InsufficientFundsException {
        if (!(pin.equalsIgnoreCase(userPin))) throw new InvalidPinException("incorrect pin for the given account");
        if (pin.equalsIgnoreCase(userPin) && amountToBeWithdrawn > 0 && amountToBeWithdrawn <= balance) return true;
        throw new InsufficientFundsException("insufficient funds , check your balance and try again");
    }


    public void setNumber(Long numbers){

        this.number = numbers;

    }

public Long getNumber(){
        return number;
}





    public String toString(){

        return this.name +" with the "+"account number"+" "+this.number;

    }


}



