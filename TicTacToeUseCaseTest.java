import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeUseCaseTest {
    private TicTacToeUseCase ticTacToe;

    @BeforeEach
    public void setUp() {
        ticTacToe = new TicTacToeUseCase();
    }

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

    @Test
    public void testMakeMoveInvalid() {
        // Given
        int row = 0;
        int col = 0;
        ticTacToe.makeMove(row, col); // Make a valid move first

        // When
        boolean result = ticTacToe.makeMove(row, col); // Attempt to make the same move again

        // Then
        Assertions.assertFalse(result); // Expecting false for invalid move
    }

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
