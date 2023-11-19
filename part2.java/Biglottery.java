import java.util.Scanner;
public class Biglottery{
public static void main(String [] args){
Scanner input = new Scanner(System.in);

int LotteryNum = 126;

System.out.println("enter any three digit number to start");
int Userguess = input.nextInt(); 



int lotD1 = LotteryNum%10;
int rem1 = LotteryNum/10;

int lotD2 = rem1%10;
int rem2 = rem1/10;

int lotD3 = rem2%10;

int UserD1 = Userguess % 10;
int Userrem1 = Userguess/10 ;

int UserD2 = Userrem1 % 10;
int Userrem2 = Userrem1 / 10 ;

int UserD3 = Userrem2 % 10;

if ( Userguess == LotteryNum ) 

System.out.println("congratulations you won $10,000");


else if  (UserD1 == lotD1 || UserD1 == lotD2 || UserD1 == lotD3 && UserD2 == lotD1
    || UserD2 == lotD2 || UserD2 == lotD3 && UserD3 == lotD1 || UserD3 == lotD2
    || UserD3 == lotD3 ) { 

    System.out.println("congrats you won $3,000");  }

else if( UserD1 == lotD1 || UserD1 == lotD2 || UserD1 == lotD3 || UserD2 == lotD1
        || UserD2 == lotD2 || UserD2 == lotD3 || UserD3 == lotD1 || UserD3 == lotD2
          || UserD3 == lotD3){

         System.out.println("congrats you won $1,000");  }
else {
       System.out.println("try again !!");  }

									}
								}









