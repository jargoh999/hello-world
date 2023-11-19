import java.util.Scanner;
public class Circle{ 
public static void main(String[]args){

Scanner input = new Scanner ( System.in) ;


System.out.println ( "enter your radius value");


int radius = input.nextInt(); 

double PI = 3.14159;

double diameter = 2 * radius; 

double cirC = 2* PI * radius;

double area = PI * (radius * radius) ;

System.out.printf( "diameter is :%.2f%n circumference is :%.2f%n area is %.2f%n", diameter, cirC, area );  

}
}