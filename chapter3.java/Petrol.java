
import java.util.Scanner;

public class Petrol{

public static void main ( String [] args) { 

Scanner input = new Scanner(System.in ) ;

PetrolPurchase Petrol = new PetrolPurchase();
System.out.println( "enter location");
String place = input.nextLine ();
Petrol.setLocation(place);


System.out.println( "enter type");
String petrolType = input.nextLine ();
Petrol.setPetrolType(petrolType);


System.out.println( "enter quantity");
int quantity = input.nextInt ();
Petrol.setQuantity(quantity);


System.out.println( "enter price");
double pricePerLiter = input.nextDouble();
Petrol.setPricePerLiter(pricePerLiter);

System.out.println( "enter discount");
double discount = input.nextDouble ();
Petrol.setDiscount (discount);











System.out.printf("%s petrol station sells %s of  %d  litre for %.3f$ per liter  so i purchased %.3f$ worth", Petrol.getLocation(), Petrol.getPetrolType(), Petrol.getQuantity(), Petrol.getPricePerLiter(), Petrol.getPurchaseAmount());


}

}