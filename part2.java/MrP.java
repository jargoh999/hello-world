import java.util.Scanner;

public class MrP{
	public static void main(String[] args){
		Scanner inputCollector = new Scanner(System.in);
		System.out.println("Enter a value: ");
		int Scamper = inputCollector.nextInt();

		if ( Scamper % (Scamper/2) !=  0)                   
                 System.out.println("this is a prime number ");
		 
		else{
		 System.out.println(" not a prime number ");
		}
	}
}