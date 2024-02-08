import java.util.ArrayList;
import java.util.Scanner;
public class InputToAsterisks {
    public static ArrayList<Integer> populateArrayOfNumber() {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("enter an integer");
        int value = scan.nextInt();

        while ( value > 0 && value < 15) {
            numbers.add(value);
            System.out.println("enter an integer");
            value = scan.nextInt();
        }
        return numbers;
    }
    private static void getAsterisks(ArrayList<Integer> numbers) {
        for (int index  = 0; index  < numbers.size(); index ++) {
            int i = 0;
            while (i++ < numbers.get(index))
                System.out.print("*");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        getAsterisks(populateArrayOfNumber());
    }
}