

import java.util.Scanner;
public class HeadOrTail{
public static void main(String [] args){
Scanner input = new Scanner(System.in);

int HorT = (1*0);

System.out.println("enter 0 or 1 to play ");
int UserTrial = input.nextInt();

if ( UserTrial <= 1 ) { 
System.out.printf ("the result of this flip is %d%n" ,HorT);}

else{ 
System.out.println("invalid input!");}


if (UserTrial == HorT ){ 
System.out.print ("congratulations you won!!!");}

else{
System.out.print ("oops try again!!!");}

				}
			}




