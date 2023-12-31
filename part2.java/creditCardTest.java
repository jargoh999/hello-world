import java.util.Scanner;
public class creditCardTest{ 

    public static void main (String [] args ){ 
    Scanner input = new Scanner (System.in);
    creditCard Card = new creditCard();
    System.out.println("hello kindly enter your card details to verify");
    long theNum = input.nextLong();
    System.out.println();
 
     Card.Validator(theNum);

} } 

         