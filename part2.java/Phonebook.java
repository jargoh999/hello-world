import java.util.HashMap;
import java.util.Scanner;
public class Phonebook{
    private static Scanner input = new Scanner(System.in);
    public static HashMap<String,String> contacts = new HashMap<>();

    public static void  addContact(String ContactName , String phoneNumber){

             contacts.put(ContactName,phoneNumber);
    }

    public static String  searchContact(String contactName){
            if (contacts.containsKey(contactName)){
                return String.format("%s Number is %s",contactName,contacts.get(contactName));}
           return String.format("this contact is not saved at the phonebook");}
    public  static void deleteContacts(String contactName){
           contacts.remove(contactName);}
   public  static void displayContacts(){
        contacts.forEach((contact,phoneNumber) ->
                System.out.println( contact + " <--> "+ phoneNumber));
   }
   public static void EditContact (String contactName , String phoneNumber){
          contacts.replace(contactName,phoneNumber);
   }
    public static void displayMenu(){ System.out.println("Select an option \n 1. save Contact \n 2." +
            " search Contact \n 3. delete Contact \n 4. Display Contacts \n 5. EditContact \n 6. BackToMenu");}

    public static void main(String[] args) {
         displayMenu();
        while (input.hasNext()){

            int options = input.nextInt();
            switch (options) {
                case 1:
                    System.out.println("enter the name of the contact to be saved");
                    String ContactName = input.next();
                    System.out.println("enter a phonenumber to be saved");
                    String PhoneNumber = input.next();
                    addContact(ContactName, PhoneNumber);
                    System.out.println("Saved successfully >>>>");
                    break;
                case 2:
                    System.out.println("enter the name of the contact to be searched");
                    String contactToBeSearched = input.next();
                    System.out.println(searchContact(contactToBeSearched));
                    break;

                case 3:
                    System.out.println("enter the name of the contact to be deleted");
                    String contactToBeDeleted = input.next();
                    deleteContacts(contactToBeDeleted);
                    break;
                case 4:
                    System.out.println("displaying your contacts");
                    displayContacts();
                    break;
                case 6:
                    System.out.println("thanks for your time ");
                    break;
                case 5:
                    System.out.println("enter the contact name");
                    String contactToBeEdited = input.next();
                    System.out.println(" enter new number ");
                    String numberToBeEdited = input.next();
                    EditContact(contactToBeEdited,numberToBeEdited);
                    break;

            }
            System.out.println("are you done ?");
            String verify = input.next();
            if (verify.equalsIgnoreCase("yes")){
                break;
            } else if (verify.equalsIgnoreCase("no")) {

                displayMenu();
            }
        }

    }

}
