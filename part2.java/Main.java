import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void mainApp() {
        TicTacToe ticTacToe = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        boolean stop1 = false;
        boolean stop2 = false;
        System.out.println("let the game Begin !!!");
        try{
        for (int move = 1; move < 5 ; move++) {
            Player player1 = new Player(1);
            Player player2 = new Player(2);
            System.out.println("player 1 turn");
            int tileToPlay = scanner.nextInt();
            player1.play(ticTacToe, tileToPlay);
            stop1 = ticTacToe.hasAWinner(tileToPlay);
            if (stop1) break;
            ticTacToe.displayTile();
            System.out.println("player 2 turn");
            int tileToPlay2 = scanner.nextInt();
            player2.play(ticTacToe, tileToPlay2);
            stop2 = ticTacToe.hasAWinner(tileToPlay2);
            if (stop2) break;
            ticTacToe.displayTile();
        }

        }catch (IllegalArgumentException| InputMismatchException|TileNotEmptyException exception){
            System.out.println("respect your self you raised "+ exception +" ");
            mainApp();
        }
        if (stop1)System.out.println("player 1 wins !!!");
        if(stop2) System.out.println("player 2 wins !!!");
        else System.out.println("it's a draw");



    }

    public static void main(String[] args) {
        mainApp();
    }
}
