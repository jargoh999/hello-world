
import java.util.Scanner;

public class Chapter5Task {

public static void main ( String [] args){

Scanner input = new Scanner( System.in);
 

System.out.println( "enter a value"); 
int Gnome1 = input.nextInt();

System.out.println( "enter a value"); 
int Gnome2 = input.nextInt();

System.out.println( "enter a value"); 
int Gnome3 = input.nextInt();

System.out.println( "enter a value"); 
int Gnome4 = input.nextInt();

System.out.println( "enter a value"); 
int Gnome5 = input.nextInt();




for( int i = 1 ; i < Gnome1 ; i++){
   System.out.print("*");}
   System.out.println("");

for( int i = 1 ; i < Gnome2 ; i++){
   System.out.print("*");}
System.out.println("");

for( int i = 1 ; i < Gnome3 ; i++){
   System.out.print("*");}
System.out.println("");

for( int i = 1 ; i < Gnome4 ; i++){
   System.out.print("*");}
System.out.println("");


for( int i = 1 ; i < Gnome5 ; i++){
   System.out.print("*");}
System.out.println("");

}
}
