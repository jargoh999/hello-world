import java.util.Scanner;

public class Exercise8{

public static void main(String [] args){

Scanner input = new Scanner(System.in);

System.out.print ( "enter an integer \n");

int firstNo = input.nextInt();

System.out.print ( "enter an integer \n");

int secNo = input.nextInt();

System.out.print ( "enter an integer \n");

int thirdNo = input.nextInt();

System.out.print ( "enter an integer \n");

int fourthNo = input.nextInt();

System.out.print ( "enter an integer \n");

int fifthNo = input.nextInt();

int min = firstNo;



 if( firstNo > secNo ) 
   min = secNo ;

 if( secNo > thirdNo) 
min = thirdNo;

 if( thirdNo > fourthNo ) 
min = fourthNo ; 

if( fourthNo > fifthNo ) 
min = fifthNo; 







int max = firstNo ;
 

if ( firstNo  < secNo ) 
 max = secNo ;

if( secNo < thirdNo) 
max = thirdNo;

if ( thirdNo < fourthNo ) 
max = fourthNo ; 

if( fourthNo < fifthNo ) 

max = fifthNo; 





System.out.printf( "maximum  is %d%n", max);







System.out.printf( "minimum is %d%n", min);

























}
}
