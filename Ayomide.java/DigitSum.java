import java.util.Scanner;
public class DigitSum{
public static void main(String [] args){
Scanner input = new Scanner(System.in);
 System.out.print("enter an integer:");
 int UserNum = input.nextInt();

if(UserNum %5 == 0 || UserNum%6 == 0 ){
System.out.println("is number is divisible by 5 or 6  ? true ");}
else{System.out.println("is number  divisible by 5 or 6 ? false ");}

if (UserNum%5 != 0 || UserNum%6 !=0){
System.out.println("is number  divisible by 5 or 6 , but not both ? true");}


else{ 
System.out.println("is number divisible by 5 or  6, but not both? false ");}



 if(UserNum %5 == 0 && UserNum % 6 == 0){
System.out.println("is number is divisible by 5 and  6? true ");}
else{System.out.println("is number  divisible by 5 and  6? false");}


}
}