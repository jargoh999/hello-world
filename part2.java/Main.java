import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.*;

public class Main {
    public static void mainApp() {
        TicTacToe ticTacToe = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        boolean player1Wins = false;
        boolean player2Wins = false;
        System.out.println("let the game Begin !!!");
       try {
            Player player1 = new Player(1);
            Player player2 = new Player(2);

       while (true) {
           System.out.println("player 1 turn");
           int tileToPlay = scanner.nextInt();
           player1.play(ticTacToe, tileToPlay);
           player1Wins = ticTacToe.hasAWinner(tileToPlay);
           if(player1Wins)break;
           if(ticTacToe.gameIsADraw())break;
           ticTacToe.displayTile();
           System.out.println("player 2 turn");
           int tileToPlay2 = scanner.nextInt();
           player2.play(ticTacToe, tileToPlay2);
           player2Wins = ticTacToe.hasAWinner(tileToPlay2);
           if(player2Wins)break;
           ticTacToe.displayTile();
        }
        }catch (IllegalArgumentException| InputMismatchException|TileNotEmptyException exception){System.out.println("respect your self you raised "+ exception +" ");
            mainApp();
        }
        if (player1Wins)System.out.println("player 1 wins !!!");
        if(player2Wins) System.out.println("player 2 wins !!!");
        if(ticTacToe.gameIsADraw()) System.out.println("it's a draw");
    }
    public static void main (String[]args){
                mainApp();
            }
        }



