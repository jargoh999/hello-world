import java.util.Scanner;

public class Exercise215{

public static void main(String [] args){

Scanner input = new Scanner(System.in);

System.out.print ( "enter an integer \n");

int firstNo = input.nextInt();

System.out.print ( "enter an integer \n");

int secNo = input.nextInt();

int square1 = firstNo * firstNo ;

int square2 = secNo * secNo ;

int sumSquare = square1 + square2;

int diffsquare = square1 - square2;

System.out.printf ( "square 1 = %d%n square2 = %d%n sum of the square =%d%n the diff of the square = %d ",square1, square2 , sumSquare, diffsquare );

           }
         		}