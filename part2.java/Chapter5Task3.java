
import java.util.Scanner;

public class Chapter5Task3 {

public static void main ( String [] args){

Scanner input = new Scanner(System.in);
 


int counter = 0 ; 
 System.out.println("enter a value"); 
  double Gnome1 = input.nextDouble();
 
while ( counter < 12){ 

  double muli = (double) Gnome1 * counter;



  counter ++ ; 

System.out.printf(" %d * %.2f = %.2f%n ", counter , Gnome1 , muli); }




}
   }  