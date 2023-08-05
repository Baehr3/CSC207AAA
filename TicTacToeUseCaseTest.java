import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The TicTacToeUseCaseTest class contains unit tests for the TicTacToeUseCase class.
 */
public class TicTacToeUseCaseTest {
    private TicTacToeUseCase ticTacToe;

    @BeforeEach
    public void setUp() {
        ticTacToe = new TicTacToeUseCase();
    }

    /**
     * Test case to verify that a valid move can be made on the game board.
     * The test checks if the move is marked correctly on the board and returns true for a valid move.
     */
    @Test
    public void testMakeMoveValid() {
        // Given
        int row = 0;
        int col = 0;
        char currentPlayer = ticTacToe.getCurrentPlayer();

        // When
        boolean result = ticTacToe.makeMove(row, col);

        // Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(currentPlayer, ticTacToe.getBoard()[row][col]);
    }

    /**
     * Test case to verify that an invalid move is not allowed on the game board.
     * The test checks if the same move cannot be made twice and returns false for an invalid move.
     */
    @Test
    public void testMakeMoveInvalid() {
        // Given
        int row = 0;
        int col = 0;
        ticTacToe.makeMove(row, col); // Make a valid move first

        // When
        boolean result = ticTacToe.makeMove(row, col); // Attempt to make the same move again

        // Then
        Assertions.assertFalse(result); // Expecting false for an invalid move
    }

    /**
     * Test case to verify winning condition when there is a horizontal row of the same symbol.
     * The test sets up a game board with a winning horizontal row and checks if the game is won.
     */
    @Test
    public void testCheckWinHorizontal() {
        // Given
        char[][] board = {
                {'X', 'X', 'X'},
                {'O', 'O', ' '},
                {' ', ' ', ' '}
        };
        ticTacToe.setBoard(board);

        // When
        boolean result = ticTacToe.checkWin();

        // Then
        Assertions.assertTrue(result);
    }

    /**
     * Test case to verify winning condition when there is a vertical column of the same symbol.
     * The test sets up a game board with a winning vertical column and checks if the game is won.
     */
    @Test
    public void testCheckWinVertical() {
        // Given
        char[][] board = {
                {'X', 'O', ' '},
                {'X', 'O', ' '},
                {'X', ' ', ' '}
        };
        ticTacToe.setBoard(board);

        // When
        boolean result = ticTacToe.checkWin();

        // Then
        Assertions.assertTrue(result);
    }
}
