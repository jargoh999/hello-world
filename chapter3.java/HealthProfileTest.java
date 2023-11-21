import java.util.Scanner ; 

public class HealthProfileTest{ 

public static void main (String [] args ){ 

Scanner input = new Scanner( System.in);

HealthProfile Health1 = new HealthProfile();


System.out.println("enter first name ");
String  firstName = input.nextLine ();
Health1.setfirstName(firstName ) ; 


System.out.println("enter last name ");
String  LastName = input.nextLine ();
Health1.setLastName(LastName ) ;


System.out.println("enter gender  ");
String gender = input.nextLine ();
Health1.setgender(gender) ;


System.out.println("enter date of birth ");
String  DOB = input.nextLine ();
Health1.setDOB(DOB ) ;


System.out.println("enter your weight ");
int  weight = input.nextInt();
Health1.setweight(weight ) ;

System.out.println("enter your height ");
int  height = input.nextInt();
Health1.setheight(height ) ;


System.out.println("enter year ");
int YearOfBirth = input.nextInt();
Health1.setYearOfBirth(YearOfBirth ); 







System.out.printf(" %s %s born in %d aged %d has %.2f heartrate and his target rate is between %.2f to %.2f%n ", Health1.getfirstName(),Health1.getLastName(),  
Health1.getYearOfBirth(),Health1.getAge(),Health1.getMaxheartRate(),Health1.getminTargetRate(),Health1.getmaxTargetRate() );
 
System.out.printf ("his date of birth is %s , an healthy  %s  of %dmetres height and %dkg weight with the BMI value of %.2f  ", Health1.getDOB(), Health1.getgender(),Health1.getheight(), Health1.getweight(),Health1.getBMI() );
}
}