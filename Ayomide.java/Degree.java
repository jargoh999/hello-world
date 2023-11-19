import java.util.scanner;
public class DegreeTocelsius{
public static void main(string [] args){
Scanner input = new Scanner(system.in);

System.out.println("enter your degree value:");
double celsius = input.nextDouble();
double farenheit = (double) (9/5)* celsius + 32;

system.out.printf("%.24f %n", farenheit);