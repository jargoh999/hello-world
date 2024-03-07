import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TicTacToeTest {

    @Test
    public void testThatCellIsFilledWithDummyValues() {
        TicTacToe ticTacToe = new TicTacToe();
        value_in_cell[][] expected = {{value_in_cell.EMPTY, value_in_cell.EMPTY, value_in_cell.EMPTY},
                {value_in_cell.EMPTY, value_in_cell.EMPTY, value_in_cell.EMPTY},
                {value_in_cell.EMPTY, value_in_cell.EMPTY, value_in_cell.EMPTY}};
        assertArrayEquals(ticTacToe.getValueInCells(), expected);
    }


    @Test
    public void testThatOnlyTwoPlayersCanPlayTheGame() {
        TicTacToe ticTacToe = new TicTacToe();
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        var ref = new Object() {
            Player player3;
        };
        assertThrows(IllegalArgumentException.class, () -> ref.player3 = new Player(3));
    }

    @Test
    public void testThatTwoGamesCanBeCreatedWithTwoPlayers() {
        TicTacToe ticTacToe = new TicTacToe();
        TicTacToe ticTacToe1 = new TicTacToe();
        Player Player1 = new Player(1);
        Player player2 = new Player(2);
        Player playerA = new Player(1);
        Player playerB = new Player(2);
        assertArrayEquals(ticTacToe.getValueInCells(), ticTacToe1.getValueInCells());
    }


    @Test
    public void testThatPlayerHasDistinctMarkOnTile() {
        Player player = new Player(1);
        assertEquals(value_in_cell.X, player.getPlayerSignature());
    }

    @Test
    public void testThatEachPlayerHasDifferentMarkOnGameTile() {
        TicTacToe ticTacToe = new TicTacToe();
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        assertEquals(value_in_cell.X, player1.getPlayerSignature());
        assertEquals(value_in_cell.O, player2.getPlayerSignature());
    }

    @Test
    public void testThatEachPlayerCanPlayGame() {
        TicTacToe ticTacToe = new TicTacToe();
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        assertEquals(value_in_cell.X, player1.getPlayerSignature());
        assertEquals(value_in_cell.O, player2.getPlayerSignature());
        player1.play(ticTacToe, 1);
        player2.play(ticTacToe, 2);
        assertNotEquals(ticTacToe.getValueInCells()[0][0], value_in_cell.EMPTY);
        assertNotEquals(ticTacToe.getValueInCells()[0][1], value_in_cell.EMPTY);

    }

    @Test
    public void testThatPlayerCanMarkGameTile() {
        TicTacToe ticTacToe = new TicTacToe();
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        assertEquals(value_in_cell.X, player1.getPlayerSignature());
        assertEquals(value_in_cell.O, player2.getPlayerSignature());
        player1.play(ticTacToe, 1);
        assertEquals(ticTacToe.getValueInCells()[0][0], player1.getPlayerSignature());
        assertEquals(ticTacToe.getValueInCells()[0][1], value_in_cell.EMPTY);

    }

    @Test
    public void testThatDifferentPlayersCanMarkTileDifferently() {
        TicTacToe ticTacToe = new TicTacToe();
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        assertEquals(value_in_cell.X, player1.getPlayerSignature());
        assertEquals(value_in_cell.O, player2.getPlayerSignature());
        player1.play(ticTacToe, 1);
        player2.play(ticTacToe, 2);
        assertEquals(ticTacToe.getValueInCells()[0][0], player1.getPlayerSignature());
        assertEquals(ticTacToe.getValueInCells()[0][1], player2.getPlayerSignature());
    }

    @Test
    public void testThatPlayersCantPlayOnAMarkedTile() {
        TicTacToe ticTacToe = new TicTacToe();
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        assertEquals(value_in_cell.X, player1.getPlayerSignature());
        assertEquals(value_in_cell.O, player2.getPlayerSignature());
        player1.play(ticTacToe, 1);
        assertEquals(ticTacToe.getValueInCells()[0][0], player1.getPlayerSignature());
        assertThrows(TileNotEmptyException.class, () -> player2.play(ticTacToe, 1));
    }

    @Test
    public void testThatPlayersCanPlayDifferentGames() {
        TicTacToe ticTacToe = new TicTacToe();
        TicTacToe ticTacToe1 = new TicTacToe();
        Player player1 = new Player(1);
        Player playerA = new Player(1);
        assertEquals(value_in_cell.X, player1.getPlayerSignature());
        assertEquals(value_in_cell.X, playerA.getPlayerSignature());
        player1.play(ticTacToe, 1);
        playerA.play(ticTacToe1, 1);
        assertEquals(ticTacToe.getValueInCells()[0][0], player1.getPlayerSignature());
        assertEquals(ticTacToe1.getValueInCells()[0][0], playerA.getPlayerSignature());
    }

    @Test
    public void testThatAnyNumberMoreThan9_throwsAnException() {
        TicTacToe ticTacToe = new TicTacToe();
        TicTacToe ticTacToe1 = new TicTacToe();
        Player player1 = new Player(1);
        Player playerA = new Player(1);
        assertEquals(value_in_cell.X, player1.getPlayerSignature());
        assertEquals(value_in_cell.X, playerA.getPlayerSignature());
        player1.play(ticTacToe, 1);
        assertThrows(IllegalArgumentException.class, () -> playerA.play(ticTacToe1, 10));
    }

    @Test
    public void testThatPlayIsOverloaded() {
        TicTacToe ticTacToe = new TicTacToe();
        TicTacToe ticTacToe1 = new TicTacToe();
        Player player1 = new Player(1);
        Player playerA = new Player(1);
        assertEquals(value_in_cell.X, player1.getPlayerSignature());
        assertEquals(value_in_cell.X, playerA.getPlayerSignature());
        player1.play(ticTacToe, 1);
        playerA.play(ticTacToe1, 1, 1);
        assertEquals(ticTacToe1.getValueInCells()[1][1], playerA.getPlayerSignature());
    }

    @Test
    public void testThatOverloadedPlayThrowsAnException() {

        TicTacToe ticTacToe = new TicTacToe();
        TicTacToe ticTacToe1 = new TicTacToe();
        Player player1 = new Player(1);
        Player playerA = new Player(1);
        assertEquals(value_in_cell.X, player1.getPlayerSignature());
        assertEquals(value_in_cell.X, playerA.getPlayerSignature());
        player1.play(ticTacToe, 1);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> playerA.play(ticTacToe1, 1, 8));
    }


    @Test
    public void testThatOverloadedPlayThrowsAnExceptionWhenTileIsMarked() {
        TicTacToe ticTacToe = new TicTacToe();
        TicTacToe ticTacToe1 = new TicTacToe();
        Player player1 = new Player(1);
        Player playerA = new Player(1);
        assertEquals(value_in_cell.X, player1.getPlayerSignature());
        assertEquals(value_in_cell.X, playerA.getPlayerSignature());
        player1.play(ticTacToe, 1, 1);
        assertThrows(TileNotEmptyException.class, () -> player1.play(ticTacToe, 1, 1));
    }

    @Test
    public void testThatBoardCanBeDisplayed() {
        TicTacToe ticTacToe = new TicTacToe();
        TicTacToe ticTacToe1 = new TicTacToe();
        Player player1 = new Player(1);
        Player playerA = new Player(1);
        assertEquals(value_in_cell.X, player1.getPlayerSignature());
        assertEquals(value_in_cell.X, playerA.getPlayerSignature());
        player1.play(ticTacToe, 1, 1);
        ticTacToe.displayTile();
    }

    @Test
    public void testThatBoardOfGamesCanBeDisplayedSeparately() {
        TicTacToe ticTacToe = new TicTacToe();
        TicTacToe ticTacToe1 = new TicTacToe();
        Player player1 = new Player(1);
        Player playerA = new Player(1);
        assertEquals(value_in_cell.X, player1.getPlayerSignature());
        assertEquals(value_in_cell.X, playerA.getPlayerSignature());
        player1.play(ticTacToe, 1, 1);
        playerA.play(ticTacToe1, 6);
        ticTacToe.displayTile();
        ticTacToe1.displayTile();
    }

    @Test
    public void testThatThereCanBeWinner() {

        TicTacToe ticTacToe = new TicTacToe();
        TicTacToe ticTacToe1 = new TicTacToe();
        Player player1 = new Player(1);
        Player playerA = new Player(1);
        assertEquals(value_in_cell.X, player1.getPlayerSignature());
        assertEquals(value_in_cell.X, playerA.getPlayerSignature());
        player1.play(ticTacToe, 1);
        assertFalse(ticTacToe.hasAWinner(1));
        player1.play(ticTacToe, 2);
        assertFalse(ticTacToe.hasAWinner(2));
        player1.play(ticTacToe, 3);
        assertTrue(ticTacToe.hasAWinner(3));
        ticTacToe.displayTile();
    }

    @Test
    public void testThatPlayerCanWinDiagonally() {

        TicTacToe ticTacToe = new TicTacToe();
        TicTacToe ticTacToe1 = new TicTacToe();
        Player player1 = new Player(1);
        Player playerA = new Player(1);
        assertEquals(value_in_cell.X, player1.getPlayerSignature());
        assertEquals(value_in_cell.X, playerA.getPlayerSignature());
        player1.play(ticTacToe, 1);
        assertFalse(ticTacToe.hasAWinner(1));
        player1.play(ticTacToe, 5);
        assertFalse(ticTacToe.hasAWinner(5));
        player1.play(ticTacToe, 9);
        assertTrue(ticTacToe.hasAWinner(9));
        ticTacToe.displayTile();

    }

    @Test
    public void testThatPlayerCanWinAntiDiagonally() {

        TicTacToe ticTacToe = new TicTacToe();
        TicTacToe ticTacToe1 = new TicTacToe();
        Player player1 = new Player(1);
        Player playerA = new Player(1);
        assertEquals(value_in_cell.X, player1.getPlayerSignature());
        assertEquals(value_in_cell.X, playerA.getPlayerSignature());
        player1.play(ticTacToe, 3);
        assertFalse(ticTacToe.hasAWinner(3));
        player1.play(ticTacToe, 5);
        assertFalse(ticTacToe.hasAWinner(5));
        player1.play(ticTacToe, 7);
        assertTrue(ticTacToe.hasAWinner(7));
        ticTacToe.displayTile();

    }

    @Test
    public void testThatPlayerCanWinOnARow() {

        TicTacToe ticTacToe = new TicTacToe();
        TicTacToe ticTacToe1 = new TicTacToe();
        Player player1 = new Player(1);
        Player playerA = new Player(1);
        assertEquals(value_in_cell.X, player1.getPlayerSignature());
        assertEquals(value_in_cell.X, playerA.getPlayerSignature());
        player1.play(ticTacToe, 1);
        assertFalse(ticTacToe.hasAWinner(1));
        player1.play(ticTacToe, 4);
        assertFalse(ticTacToe.hasAWinner(4));
        player1.play(ticTacToe, 7);
        assertTrue(ticTacToe.hasAWinner(7));
        ticTacToe.displayTile();

    }

    @Test
    public void testThatPlayerCanDrawOnARow() {
        TicTacToe ticTacToe = new TicTacToe();
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        assertEquals(value_in_cell.X, player1.getPlayerSignature());
        assertEquals(value_in_cell.O, player2.getPlayerSignature());
        player1.play(ticTacToe, 1);
        assertFalse(ticTacToe.hasAWinner(1));
        player2.play(ticTacToe,2);
        assertFalse(ticTacToe.hasAWinner(2));
        player1.play(ticTacToe, 3);
        assertFalse(ticTacToe.hasAWinner(3));
        player2.play(ticTacToe,4);
        assertFalse(ticTacToe.hasAWinner(4));
        ticTacToe.displayTile();
        player1.play(ticTacToe,5);
        assertTrue(ticTacToe.hasAWinner(5));
        player2.play(ticTacToe,8);
        assertFalse(ticTacToe.hasAWinner(8));
        player1.play(ticTacToe,7);
        assertFalse(ticTacToe.hasAWinner(7));
        ticTacToe.displayTile();
//        player2.play(ticTacToe,8);
//        assertFalse(ticTacToe.hasAWinner(8));
//        ticTacToe.displayTile();

    }

}
