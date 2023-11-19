import java.util.Scanner;

public class Exercise4{

public static void main(String [] args){

Scanner input = new Scanner(System.in);

System.out.print ( "enter an integer \n");

int firstNo = input.nextInt();

System.out.print ( "enter an integer \n");

int secNo = input.nextInt();

System.out.print ( "enter an integer \n");

int thirdNo = input.nextInt();

int sum = firstNo + secNo + thirdNo ;

int average = sum/2 ;

int product = firstNo * secNo * thirdNo;

if ( firstNo < secNo && secNo < thirdNo ) 
System.out.printf( "the lowest number is %d%n", firstNo );

if ( firstNo > secNo && secNo > thirdNo) 
System.out.printf( "the highest number is %d%n", secNo );

if ( secNo < firstNo && secNo < thirdNo )
System.out.printf("the lowest number is %d%n ", secNo);

if ( secNo > firstNo && secNo > thirdNo)
System.out.printf("the highest number is %d%n ", secNo);

if ( thirdNo > firstNo && thirdNo > secNo ) 
System.out.printf("the highest number is %d%n ", thirdNo);

if( thirdNo < firstNo && thirdNo < secNo ) 
System.out.printf("the lowest number is %d%n ", thirdNo);


System.out.printf("sum is %d%n average is %d%n  product is %d%n ", sum, average , product );
 

								}
									}


