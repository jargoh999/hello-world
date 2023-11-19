import java.util.Scanner;
public class Numprinter{ 
public static void main(String[]args){

Scanner input = new Scanner ( System.in) ;


System.out.println("enter any five digits");

int UserNum = input.nextInt();

int digit1 = UserNum %10;
int rem1 = UserNum / 10;

int digit2 = rem1 %10;
int rem2 = rem1 / 10;

int digit3 = rem2 %10;
int rem3 = rem2 / 10;

int digit4 = rem3 % 10;
int rem4 = rem3 / 10;

int digit5 = rem4 % 10;


System.out.printf("%d   %d   %d   %d   %d    ", digit5, digit4, digit3, digit2, digit1);

}

}