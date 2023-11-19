import java.util.Scanner;
public class Squareprinter{ 
public static void main(String[]args){

Scanner input = new Scanner ( System.in) ;

int counter = 0;


System .out.println("enter any  digit");
int num = input.nextInt();

System.out.printf("%S%15S%S%15s %S%n",  "number","","square","","cube");


while (counter < 10) { 

System.out.printf("%d%20s %d%20s %d%n", num ,"", num*num,"", num*num*num);
num++;
counter++;


}
 		} 

				}








