import java.util.Scanner;
public class TestDiary {
    private static Scanner input = new Scanner(System.in);
    private static Diary diary = new Diary("ayo","1234");
    public static void main(String[] args) {


     //diary.lockDiary();
        print("welcome to mavericks E_Diary");

     //diary.createEntry("");




    }

    public static void lockDiary(){
        print("do you want to lock your diary");
        String reply = input.next();
        if (reply.equalsIgnoreCase("yes"))diary.lockDiary();
        print("your diary is locked successfully");
    }
    private static void print(String message){
        System.out.println(message);
    }

    private static void displayMenu(){
        print("""
                enter 1 to create an entry +
                +enter 2 to find an entry+
                +enter 3 to update an entry+
                +enter 4 to delete an entry+
                """);

    }


    public static void createEntry(){
        print("enter the body of your");
        diary.createEntry();




    }
}