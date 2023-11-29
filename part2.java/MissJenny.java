import java.util.Scanner;

public class MissJenny{

public static void main ( String [] args){

Scanner input = new Scanner( System.in); 

 int highest = 0;
 String Highestname = "";
 System.out.println("enter student nmumber: ");
 int StudNum = input.nextInt();
 
for( int i = 1; i <= StudNum ; i++){ 

  
System.out.println("enter student grade : ");
 int Score  = input.nextInt();
 
System.out.println("enter student name : ");
 String StudName  = input.next();

                                   
if( Score > highest ){
  highest = Score;
  Highestname = StudName;}
    

                                      }
System.out.printf("%s has the  score : %d scored the highest ", Highestname, highest); 
   						}
                                                                                      }