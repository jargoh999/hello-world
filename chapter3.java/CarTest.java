import java.util.Scanner;

public class CarTest1{

public static void main (String [] args){

Scanner input = new Scanner ( System.in);

Car car1 = new Car ();

Car car2 = new Car ();

System.out.println ("enter a model");
String ModelB = input.nextLine();
car1.setModel(ModelB);

System.out.println("enter a model");
String ModelA = input.nextLine();
car2.setModel(ModelA);

System.out.println("enter  price for the car ");
double PriceB = input.nextDouble();
car1.SetPrice(PriceB);

System.out.println("enter  price for the car ");
double PriceA = input.nextDouble();
car2.SetPrice(PriceA);

System.out.print("enter year of manufacturing \n");
int manuYear = input.nextInt();
car1.setYEAR(manuYear);




double car1discount = car1.getPrice() - car1.getPrice()*5 / 100 ;

double car2discount = car2.getPrice() - car2.getPrice()*7 / 100 ;

System.out.printf ( "%s car of %s year costs %.2f is now for sale on discount for %.2f%n",car1.getModel(),car1.getYear(), car1.getPrice(), car1discount); 


System.out.printf ( "%s car of %s year costs %.2f is now for sale on discount for %.2f",car2.getModel(),car2.getYear(), car2.getPrice(), car2discount); 



}
}