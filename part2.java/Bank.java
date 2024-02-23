package Account_and_Bank;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Bank {
public List<Account>accounts = new ArrayList<>();
private  static Long defaultAccountNumber = 14346785324L;

    public  void deposit (long accountNumber , int amountToBeDeposited){
        for (Account value : accounts) {
            if (value.getNumber() == accountNumber) value.deposit(amountToBeDeposited);
        }
    }


    public void withdraw(long accountNumber, int amountToBeWithdrawn , String pin){

        for (Account value : accounts) {
            if (value.getNumber() == accountNumber && value.getPin().equals(pin))
                value.withdraw(amountToBeWithdrawn, pin);
        }
    }



    public void transfer(long senderAccountNumber , long recipientAccountNumber , int amountToBeTransferred, String pin ){

        for (Account value : accounts) {
            if (value.getNumber() == senderAccountNumber && value.getPin().equals(pin))
                value.withdraw(amountToBeTransferred, pin);
        }
        for (Account value : accounts) {
            if (value.getNumber() == recipientAccountNumber) value.deposit(amountToBeTransferred);
        }


    }


    public  int checkBalance(long accountNumberToBeChecked , String pin){
        for (Account value : accounts) {
            if (value.getNumber() == accountNumberToBeChecked && value.getPin().equals(pin))
                return value.checkBalance();

        }

        return 0;
    }
    public Account registerCustomer(String firstName , String lastName, String pin){
                      Account account  = new Account(firstName,lastName,pin);
                       account.setNumber(defaultAccountNumber);
                       accounts.add(account);
                       defaultAccountNumber++;
                       return account;
    }


    public void removeAccount (long accountNumberToRemove , String pin ){
        accounts.removeIf(account -> account.getNumber() == accountNumberToRemove && account.getPin().equals(pin));
    }


    public  Account findAccount(long accountNumberToFind)  {

        for (Account value : accounts) {
            if (value.getNumber() == accountNumberToFind) return value;
        }
        throw new AccountNotFoundException("account not found");
    }

    public int getNumberOfAccounts(){
        return accounts.size();
    }

    void appDisplay() {
        System.out.println("welcome to mavericks bank >>>>> how can we help you today");
        System.out.printf("%S%n%S%n%S%n%S%n%S%n%S%n%S%n", "enter 1 to deposit>>>>>>>", "enter 2 to withdraw >>>>>>>>>>", "enter 3 to transfer >>>>>>>>", "enter 4 to check Balance >>>>>>>>", "enter 5 to register customer >>>>>>>>> ", "enter 6 to remove account >>>>>>>>>>", "enter 7 to find account >>>>>>>>>>>");
    }


    public static void bankApp() {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        bank.appDisplay();
        while (scanner.hasNext()){
            try {
                int response = scanner.nextInt();
                switch (response) {
                    case 1 -> {
                        System.out.println("enter your account number");
                        long accountNumber = scanner.nextLong();
                        System.out.println("enter the amount to be deposited");
                        int amountToBeDeposited = scanner.nextInt();
                        bank.deposit(accountNumber, amountToBeDeposited);
                        System.out.printf("you deposited %d to %d account %n", amountToBeDeposited, accountNumber);
                        System.out.println();
                        bank.appDisplay();

                    }
                    case 2 -> {
                        System.out.println("enter your account number");
                        long accountNumber = scanner.nextLong();
                        System.out.println("enter the amount to be withdrawn");
                        int amountToBeWithdrawn = scanner.nextInt();
                        System.out.println("input your pin");
                        String pin = scanner.next();
                        bank.withdraw(accountNumber, amountToBeWithdrawn, pin);
                        System.out.printf("you withdraw  %d from %d account thanks for banking with us%n ", amountToBeWithdrawn, accountNumber);
                        System.out.println();
                        bank.appDisplay();
                    }
                    case 3 -> {
                        System.out.println("enter your account number");
                        long accountNumber = scanner.nextLong();
                        System.out.println("enter the recipient account number");
                        long recipientAccountNumber = scanner.nextLong();
                        System.out.println("enter the amount you will like to be transferred out of your account");
                        int amountToBeTransferred = scanner.nextInt();
                        System.out.println("input your pin");
                        String pin = scanner.next();
                        bank.transfer(accountNumber, recipientAccountNumber, amountToBeTransferred, pin);
                        System.out.print("transfer successful");
                        System.out.println();
                        bank.appDisplay();
                    }
                    case 4 -> {
                        System.out.println("enter your account number");
                        long accountNumber = scanner.nextLong();
                        System.out.println("enter your pin");
                        String pin = scanner.next();
                        var value = bank.checkBalance(accountNumber, pin);
                        System.out.println("your remaining balance is" + "     " + value);
                        System.out.println();
                        bank.appDisplay();
                    }


                    case 5 -> {
                        System.out.println("enter your first name");
                        String firstName = scanner.next();
                        System.out.println("enter your second name");
                        String secondName = scanner.next();
                        System.out.println("enter your pin");
                        String pin = scanner.next();
                        var value = bank.registerCustomer(firstName, secondName, pin);
                        System.out.println("Congrats here is your account preview " + "     " + value);
                        System.out.println();
                        bank.appDisplay();
                    }

                    case 6 -> {
                        System.out.println("enter your first name");
                        long accountNumberToRemove = scanner.nextLong();
                        System.out.println("enter your pin");
                        String pin = scanner.next();
                        bank.removeAccount(accountNumberToRemove, pin);
                        System.out.println("tchhh!!! your account has been permanently removed ");
                        System.out.println();
                        bank.appDisplay();
                    }


                    case 7 -> {
                        System.out.println("enter your first name");
                        long accountNumberToBeFound = scanner.nextLong();
                        var latestAccount = bank.findAccount(accountNumberToBeFound);
                        System.out.println(latestAccount);
                        bank.appDisplay();
                    }

                }
            } catch (InputMismatchException | Account_and_Bank.InsufficientFundsException e) {
                System.out.println(e.getMessage());
                System.out.println("respect yourself \n \n ");
                bankApp();
            } catch (AccountNotFoundException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}

class BankApp{
    public static void main(String[] args){
       Bank.bankApp();
    }
}