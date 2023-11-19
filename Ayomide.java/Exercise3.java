import java.util.Scanner;

public class Exercise3{

public static void main(String [] args){

Scanner input = new Scanner(System.in);


System.out.print ( "enter an integer \n");

int firstNo = input.nextInt();

int square1 = firstNo * firstNo ;


if ( firstNo > 100 || square1 > 100 ){

System.out.println ( "numbers is greater than 100");}

if ( firstNo == 100 || square1 == 100 ){

System.out.println ( "number is equal to 100");}

if ( firstNo != 100 || square1 != 100 ){ 

System.out.println ( "number is not equal to 100 ");}

if ( firstNo < 100 || square1 < 100 ){

System.out.println ( "number is less than 100");}
    							}

					}