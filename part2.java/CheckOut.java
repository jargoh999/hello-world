
import java.util.ArrayList;

public class CheckOut {

    private String CustomerName;
    private String CashierName;

    private double pay;
    private double discount;
    private ArrayList<String> item;
    private ArrayList<Integer> price;
    private ArrayList<Integer> total;

    public CheckOut(String CustomerName, String CashierName, double discount, double pay, ArrayList<String> item, ArrayList<Integer> price, ArrayList<Integer> total) {
        if (discount > 0) {
            this.discount = discount;
        }
        if (pay > 0) {
            this.pay = pay;
        }
        this.item = item;
        this.price = price;
        this.total = total;

    }

    public void setCusName(String CustomerName) {

        this.CustomerName = CustomerName;
    }


    public String getCusName() {

        return CustomerName;
    }


    public void setCashierName(String CashierName) {

        this.CashierName = CashierName;
    }


    public String getCashierName() {

        return CashierName;
    }

    public void setDisc(double discount) {
        if (discount > 0) {
            this.discount = discount;
        }
    }

    public double getDisc() {
        return discount;
    }


    public void setPay(double pay) {
        if (pay > 0) {
            this.pay = pay;
        }
    }

    public double getPay() {
        return pay;
    }

    public void firstReciept() {

        System.out.println("\n\n SEMICOLON STORES");
        System.out.println("MAIN BRANCH");
        System.out.println("LOCATION : 312 , HERBERT MACAULAY WAY , SABO YABA , LAGOS.");
        System.out.println("3654899277354");
        System.out.println("31-DEC-22  7:48:34 PM");
        System.out.printf("Cashier:  %s%n", getCashierName());
        System.out.printf("Customer Name:  %s%n", getCusName());
        System.out.println("==========================================================================");
        System.out.println("  ITEM        QTY          PRICE            TOTAL(NGN) ");
        System.out.println("==========================================================================");


        int Subtotal = 0;
        for (int i = 0; i < price.size(); i++) {

            int Price = price.get(i);
            int Total = total.get(i);
            int Qty = Total / Price;
            System.out.printf("%n%s%10d%15d%20d%n", item.get(i), Qty, Price, Total);
            Subtotal += Total;
        }
        System.out.println("==========================================================================");


        double vinx = getDisc();
        double discIt = (vinx / 100) * Subtotal;
        double VAT = (double) (7.5 / 100) * Subtotal;
        double Bill = Subtotal + discIt + VAT;
        System.out.printf("           Sub Total :                 %d%n", Subtotal);
        System.out.printf("           Discount :                 %.2f%n", discIt);
        System.out.printf("           VAT @ 7.5  :               %.2f%n", VAT);
        System.out.println("==========================================================================");
        System.out.printf("           Bill Total  :                %.2f%n", Bill);
        System.out.println("==========================================================================");
        System.out.printf("THIS IS NOT A RECIEPT KINDLY PAY  %.2f%n", Bill);
        System.out.println("==========================================================================");
    }


    public void returnBalance() {

        System.out.println("\n\n SEMICOLON STORES");
        System.out.println("MAIN BRANCH");
        System.out.println("LOCATION : 312 , HERBERT MACAULAY WAY , SABO YABA , LAGOS.");
        System.out.println("3654899277354");
        System.out.println("31-DEC-22  7:48:34 PM");
        System.out.printf("Cashier:  %s%n", getCashierName());
        System.out.printf("Customer Name:  %s%n", getCusName());
        System.out.println("==========================================================================");
        System.out.println("  ITEM        QTY          PRICE            TOTAL(NGN) ");
        System.out.println("==========================================================================");


        int Subtotal = 0;
        for (int i = 0; i < price.size(); i++) {

            int Price = price.get(i);
            int Total = total.get(i);
            int Qty = Total / Price;
            System.out.printf("%n%s%10d%15d%20d%n", item.get(i), Qty, Price, Total);
            Subtotal += Total;
        }

        System.out.println("==========================================================================");
        double vinx = getDisc();
        double discIt = (vinx / 100) * Subtotal;
        double VAT = (double) (7.5 / 100) * Subtotal;
        double Bill = Subtotal + discIt + VAT;
        double amountPaid = getPay();
        double balance = (double)amountPaid - Bill;


        System.out.printf("           Sub Total :                 %d%n", Subtotal);
        System.out.printf("           Discount :                 %.2f%n", discIt);
        System.out.printf("           VAT @ 7.5  :               %.2f%n", VAT);
        System.out.println("==========================================================================");
        System.out.printf("           Bill Total  :                %.2f%n", Bill);
        System.out.printf("           Amount Paid :                %.2f%n", amountPaid);
        System.out.printf("              Balance  :                %.2f%n", balance);
        System.out.println("==========================================================================");
        System.out.printf("THANK YOU FOR YOUR PATRONAGE %n");
        System.out.println("==========================================================================");

    }

}
        

       