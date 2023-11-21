import java.util.Scanner ; 

public class HeartTest{ 

public static void main (String [] args ){ 

Scanner input = new Scanner( System.in);

HeartRates heart1 = new HeartRates();


System.out.println("enter last name ");
String  firstName = input.nextLine ();
heart1.setfirstName(firstName ) ; 



System.out.println("enter year ");
int YearOfBirth = input.nextInt();
heart1.setYearOfBirth(YearOfBirth ) ; 





System.out.printf(" %s born in %d aged %d has %.2f heartrate and his target rate is between %.2f to %.2f ", heart1.getfirstName(), heart1.getYearOfBirth(),heart1.getAge(),heart1.getMaxheartRate(),heart1.getminTargetRate(),heart1.getmaxTargetRate() );

}
}