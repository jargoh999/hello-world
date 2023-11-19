import java.util.Scanner;
public class Perimeter{
public static void main(String [] args){
Scanner input = new Scanner(System.in);

System.out.println("enter side 1 ");
double side1 = input.nextDouble();


System.out.println("enter side 2 ");
double side2 = input.nextDouble();


System.out.println("enter side 3 ");
double  side3 = input.nextDouble();

if ( side1 + side2 < side3 || side2 + side3 < side1 || side3 + side1 < side2 ) { 

System.out.print("invalid input !!! ");}

else { 

double perimeter = side1 + side2 + side3 ;

System.out.printf("perimeter is : %.2fCM%n ", perimeter);}


							}

						}