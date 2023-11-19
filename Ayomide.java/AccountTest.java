
import java.util.Scanner;
public class AccountTest{

public static void main (String [] args){

Scanner input = new Scanner(System.in);

Account account1 = new Account( "beejay", 50.00);

Account account2 = new Account( "rahmon", -7.00);


System.out.println ("enter deposit amount ");

double DepositAmount = input.nextDouble(); 

account1.deposit(DepositAmount);

System.out.println ("enter withdrawal Amount ");

double WithdrawalAmount = input.nextDouble();

displayAccount(account1);
displayAccount(account2);

}


						

public static void displayAccount(Account accountToDisplay){

System.out.printf("%s account balance is $%.2f", accountToDisplay.getName(), accountToDisplay.getBalance());}


}






     						
















