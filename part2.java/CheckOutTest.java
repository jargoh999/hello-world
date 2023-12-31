
import java.util.ArrayList;
import java.util.Scanner;

public class CheckOutTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        ArrayList<String> item = new ArrayList<String>();
        ArrayList<Integer> price = new ArrayList<Integer>();
        ArrayList<Integer> total = new ArrayList<Integer>();


        do {
            System.out.println("What did the user buy");
            item.add(scan.next());
            System.out.println("how many pieces ?");
            int pieces = scan.nextInt();
            System.out.println("How much per unit");
            int pricey = scan.nextInt();
            price.add(pricey);
            int messedUp = pricey * pieces;
            total.add(messedUp);
            System.out.println("wanna add more item ?");
            String Confirmer = scan.next();
            if (Confirmer.equalsIgnoreCase("no")) {
                break;
            }
        }
        while (total.size() > -1);


        CheckOut check = new CheckOut("", "", 0, 0, item, price, total);
        System.out.println("What is the Customer Name ");
        String name = scan.next();
        check.setCusName(name);


        System.out.println("What is the your Name ");
        String Myname = scan.next();
        check.setCashierName(Myname);


        System.out.println("how much discount will he get");
        double disc = scan.nextDouble();
        check.setDisc(disc);

        check.firstReciept();

        System.out.println("how much did the customer give to you ");
        double pay = scan.nextDouble();
        check.setPay(pay);
        check.returnBalance();


    }
}







                   
                       





