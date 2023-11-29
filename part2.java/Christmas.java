import java.util.Scanner;
public class Christmas{
public static void main(String [] args){
Scanner input = new Scanner(System.in);
System.out.println(" enter number 1 - 12 to get days & gift :");

int counter = 1 ;


while( counter != 0  ){ 
 int daysOfXmas = input.nextInt();
   counter ++;    
switch (daysOfXmas){
  
 case 1 :
        System.out.println("on the first day of christmas my true love sent to me ");   
  break;

case 2 :
        System.out.println("on the second day of christmas my true love sent to me ");
  break;

case 3 :
        System.out.println("on the third day of christmas my true love sent to me ");
 break;

case 4 :
        System.out.println("on the fourth day of christmas my true love sent to me ");
 break;

case 5 :
        System.out.println("on the fifth day of christmas my true love sent to me ");
 break;
 
case 6 :
        System.out.println("on the sixth day of christmas my true love sent to me ");
 break;

case 7:
        System.out.println("on the seventh day of christmas my true love said to me ");
  break;

case 8 :
        System.out.println("on the  day of christmas my true love said to me ");
  break;

case 9 :
        System.out.println("on the ninth day of christmas my true love said to me ");
  break;

case 10 :
        System.out.println("on the tenth day of christmas my true love said to me ");
 break ;

case 11 :
        System.out.println("on the eleventh day of christmas my true love said to me ");
 break ;

case 12 :
        System.out.println("on the last day of christmas my true love said to me ");
 break;

}
  int counter2 = 1;
    System.out.println(""); 


     System.out.println("enter number to get poem ");
     

while (input.hasNext()  ){
 int counter1 = input.nextInt();
  counter2++;
 switch ( counter1){

case 12:  
        System.out.println("twelve drummers drumming");

case 11:
         System.out.println("eleven pipers piping");

case 10:
         System.out.println("ten lords are leaping");

case 9:
        System.out.println("nine ladies dancing ");

case 8:
        System.out.println("eight maids are milking");

case 7: 
        System.out.println("seven swans a-swimming"); 

case 6 :
        System.out.println("six geese a-laying");

case 5 :
         System.out.println("five gold rings");

case 4 :
         System.out.println("four calling birds");

case 3:
        System.out.println("Three French hens");

case 2 :
        System.out.println("Two turtle doves"); 

case 1 :
         System.out.println("A partridge in a pear tree");
       
          break;
                   
				}

                         break;  } 
                       }
                  
        
                    } 

                 }