import java.util.Scanner;
public class RockPaperScissors{
public static void main(String [] args){
Scanner input = new Scanner(System.in);

int paper = 0;
int rock = 1;
int Scissors = 2;


System.out.println("enter first player name :");
String player1 = input.nextLine();

System.out.println("enter second player name :");
String player2 = input.nextLine();

System.out.printf("%s enter  0,1 or 2 to play:%n",player1);
int Player1input = input.nextInt();

System.out.printf("%s enter 0,1 or 2 to play:%n", player2 );
int Player2input = input.nextInt();


if (Player1input <= 2 && Player2input <= 2){

if( Player1input == paper && Player2input == paper)
System.out.printf("%s draw %s!!! " ,player1, player2);

if( Player1input == paper && Player2input == rock)
System.out.printf("%s won %s!!! ", player1, player2);

if( Player1input == paper && Player2input == Scissors)
System.out.printf("%s won %s!!! ", player2, player1);

if( Player1input == rock && Player2input == rock)
System.out.printf("%s Draw %s!!! " ,player1, player2);

if( Player1input == rock && Player2input == paper)
System.out.printf("%s won %s!!! " ,player2, player1);

if( Player1input == rock && Player2input == Scissors)
System.out.printf("%s won %s!!! " ,player1, player2);

if( Player1input == Scissors && Player2input == Scissors)
System.out.printf("%s draw %s!!! " ,player1, player2);

if( Player1input == Scissors && Player2input == rock)
System.out.printf("%s won %s!!! " ,player2, player1);

if( Player1input == Scissors && Player2input == paper)
System.out.printf("%s won %s!!! " ,player1, player2);

}
else{


System.out.println("enter any value from 0 to 2");
}


}
 }


































