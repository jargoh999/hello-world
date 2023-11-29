import java.util.Scanner;
public class ClassSentinel{
public static void main(String [] args){
Scanner input = new Scanner(System.in);
 

int counter = 1;
int total = 0 ;
int PosCount = 0;
int NegCount = 0;
   
System.out.println("enter any number or 0 to quit");
int UserGet =  input.nextInt();

while( UserGet != 0 ){ 

counter++;

if( UserGet < 0 ){
     NegCount++;}

else if ( UserGet > 0){ 
      PosCount ++;}

if ( UserGet == 0){
System.out.println("No numbers are entered yet ");}

total += UserGet;

System.out.println("enter any number or 0 to quit");
 UserGet =  input.nextInt();

                     }

int average = total/ counter ;

System.out.printf("the number of positives is %d%n",PosCount);

System.out.printf("the number of negatives is %d%n",NegCount);

System.out.printf("total is %d%n",total);

System.out.printf("average is %d%n",average);
    						}
							}



                  

