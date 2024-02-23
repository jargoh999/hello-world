
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class CheckYears {

  public static String[] changeDateToArray(String date) {

      String[] dates = new String[3];
      String year = "";
      String month = "";
      String day = "";
      for (int index = 0; index < date.length(); index++) {
          if (index <= 3) {
              year += date.charAt(index);
          } else if (index > 4 && index <= 6) {
              month += date.charAt(index);
          } else if (index > 7) {
              day += date.charAt(index);
          }

      }
       dates[0] = day;
       dates[1] = month;
       dates[2] = year;
      return dates;
  }

        public static int checkYears(String[] date) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));

        Period periodToCheck = Period.between(birthday, today);

        int years = periodToCheck.getYears();
        int months = periodToCheck.getMonths();
        int days = periodToCheck.getDays();
         return years;

    }
    public  static int getAge(String birthday){
      return Period.between(LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd/MM/yyyy")),LocalDate.now()).getYears();
    }



    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

         System.out.println("enter your day of birth" );
        String date = input.nextLine();
         String[] dates = changeDateToArray(date);
        System.out.println(getAge(date));

    }

}
