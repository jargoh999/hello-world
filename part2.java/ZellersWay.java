import java.util.Scanner;
public class ZellersWay{
public static void main(String [] args){
Scanner input = new Scanner(System.in);

System.out.println("enter year e.g 2012 : ");
int year = input.nextInt();


System.out.println("enter day of the month 1-31 : ");
int DOM = input.nextInt();

System.out.println("enter month 1 - 12 :");
int monthNo = input.nextInt();


int century = year / 100;

int yearOfCen = year % 100;


int DaysOfWeek = (DOM + 26 * (monthNo + 1) / 10 + year + year/4 + yearOfCen/4 + 5 * century) % 7 ;




if(DaysOfWeek == 1)
System.out.print("Days Of the Week is monday");

 if(DaysOfWeek == 2)
System.out.print("Days Of the  Week is tuesday");
   
if(DaysOfWeek == 3)
System.out.print("Days Of the Week is wednesday");

if (DaysOfWeek == 4)
System.out.print("Days Of the Week is thursday");

if(DaysOfWeek == 5)
System.out.print("Days Of the Week is friday");

if(DaysOfWeek == 6)
System.out.print("Days Of the Week is saturday");

if(DaysOfWeek == 7)
System.out.print("Days Of the Week is sunday");
























}
}