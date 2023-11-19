import java.util.Scanner;
public class AgeToDaysApp{
public static void main(String [] args){
Scanner input = new Scanner(System.in);


System.out.println("enter your age:");

int Age = input.nextInt();

int getDays = Age * 365 ; 

System.out.printf("your days on earth are: %d", getDays);

} 
}
