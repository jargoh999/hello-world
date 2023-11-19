import java.util.Scanner;
public class Cashconverter {
public static void main(String [] args){
Scanner input = new Scanner(System.in);

 System.out.print("enter an exchange rate : ");
double UserRate = input.nextDouble();


 System.out.print("enter 0 to convert from $ to RMD and vice versa :  ");
 int userchoice = input.nextInt();
 
if (userchoice == 0) {
    System.out.print("enter value of dollar :  ");

      double dollar = input.nextInt();
      double DollarToRmd = dollar * UserRate ;
        System.out.printf("$%.1f is %.1f yuan ", dollar, DollarToRmd);}

 
if (userchoice == 1) {
 
    System.out.print("enter value of RMB :  ");
    double  RMB = input.nextDouble();
    double RmdtoDollar  = RMB / UserRate ;
    System.out.printf("%.1fyuan is %.1f dollar ", RMB, RmdtoDollar);}
}
}
