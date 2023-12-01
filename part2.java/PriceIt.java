
import java.util.Scanner;

public class PriceIt {

public static void main ( String [] args){

Scanner input = new Scanner( System.in);
 

System.out.println( "enter an item"); 

String item = input.nextLine();

int discount = 10;
System.out.println( "enter price");

int price = input.nextInt();
if ( price > 0){
    double total = price - (price* discount/100);
     System.out.printf("%S : %s%n %S : %d%n %S : %d%n %S : %.2f ","item", item, "price",price, "discount",discount,"total", total);
  		}

else{System.out.println( "enter a valid price");
      }
}
 }


   


                  