import java.util.Scanner;
public class Comparer{
public static void main(String [] args){
Scanner input = new Scanner(System.in);

System.out.println("enter a number ");
int num = input.nextInt();


System.out.println("enter a number ");
int num1 = input.nextInt();


System.out.println("enter a number ");
int num2 = input.nextInt();





if (num > num1 && num1 > num2 )

  System.out.printf("%d  %d   %d  ", num2 , num1 , num );

else if (num1 > num2 && num2 > num)
 
 System.out.printf("%d  %d   %d  ", num, num2 , num1); 


else if (num2 > num1 &&  num1 > num)
    
     
  System.out.printf("%d  %d   %d  ", num, num1 , num2); }


						}


                                                    