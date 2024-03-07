
public class Player {
    private int playerNo = 0;
    private value_in_cell playerSignature;

    public Player(int playerNo) {
        this.playerNo = playerNo;
        setPlayerSignature(playerNo);
    }

    public void setPlayerSignature(int playerNo) {
        if (playerNo > 2 || playerNo <= 0) throw new IllegalArgumentException("invalid player number ");
        if (playerNo == 1) this.playerSignature = value_in_cell.X;
        if (playerNo == 2) this.playerSignature = value_in_cell.O;
    }

    public value_in_cell getPlayerSignature() {
        return playerSignature;
    }

    public void play(TicTacToe ticTacToe, int rowPlayed, int columnPlayed) {
        if (isValidTile(ticTacToe, rowPlayed, columnPlayed))
            ticTacToe.getValueInCells()[rowPlayed][columnPlayed] = this.playerSignature;
    }

    private boolean isValidTile(TicTacToe ticTacToe, int rowPlayed, int columnPlayed) {
        if (ticTacToe.getValueInCells()[rowPlayed][columnPlayed] == value_in_cell.EMPTY) return true;
        throw new TileNotEmptyException("tile is occupied boss");
    }

    public void play(TicTacToe ticTacToe, int tileToPlay) {
        if (tileToPlay < 0 || tileToPlay > 9)
            throw new IllegalArgumentException("oga enter a number in the range 1-9 ");

        if (tileToPlay == 1) {
            play(ticTacToe, 0, 0);
        }
        if (tileToPlay == 2) {
            play(ticTacToe, 0, 1);
        }
        if (tileToPlay == 3) {
            play(ticTacToe, 0, 2);
        }
        if (tileToPlay == 4) {
            play(ticTacToe, 1, 0);
        }
        if (tileToPlay == 5) {
            play(ticTacToe, 1, 1);
        }
        if (tileToPlay == 6) {
            play(ticTacToe, 1, 2);
        }
        if (tileToPlay == 7) {
            play(ticTacToe, 2, 0);
        }
        if (tileToPlay == 8) {
            play(ticTacToe, 2, 1);
        }
        if (tileToPlay == 9) {
            play(ticTacToe, 2, 2);
        }
    }
}