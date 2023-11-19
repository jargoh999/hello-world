import java.util.Scanner;
public class DegreeTocelsius{
public static void main(String [] args){
Scanner input = new Scanner(System.in);

System.out.println("enter your Celsius value:");
double celsius = input.nextDouble();
double farenheit = (double)9/5* celsius + 32;

System.out.printf("%.2f celsius is %.4f in farenheit %n ",celsius, farenheit);}}