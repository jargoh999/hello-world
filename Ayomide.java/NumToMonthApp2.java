import java.util.Scanner;
public class NumToMonthApp2{
public static void main(String [] args){
Scanner input = new Scanner(System.in);

System.out.println("enter year: ");
int year = input.nextInt();


System.out.println("enter number to Get month:");
int monthNo = input.nextInt();

if(year % 4 == 0  && monthNo == 2 )
System.out.printf("february %d had 29 days ", year);
else if( year % 4 != 0 && monthNo == 2)
System.out.printf("february %d had 28 days  ", year);

else if(monthNo == 1)
System.out.printf("january %d had 31 days%n ",year );


 
   

if(monthNo == 3)
System.out.printf("march %d had 31 days ", year);

if(monthNo == 4)
System.out.printf("april %d had 30 days ", year);

if(monthNo == 5)
System.out.printf("may %d had 30 days ", year);

if(monthNo == 6)
System.out.printf("june %d had 30 days ", year);

if(monthNo == 7)
System.out.printf("july %d had 31 days", year);

if(monthNo == 8)
System.out.printf("august %d had 31 days ", year);

if(monthNo == 9)
System.out.printf("september %d had 30 days", year);

if(monthNo == 10)
System.out.printf("october %d had 31 days ", year);

if(monthNo == 11)
System.out.printf("november %d had 30 days ", year);

if(monthNo == 12)
System.out.printf("December %d had 31 days ", year);

}
}