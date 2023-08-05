import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * The TicTacToeViewTest class contains unit tests for the TicTacToeView class.
 */
public class TicTacToeViewTest {
    private TicTacToeView ticTacToeView;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        ticTacToeView = new TicTacToeView('X', 'O');
        System.setOut(new PrintStream(outputStream));
    }

    /**
     * Test case to verify the displayBoard() method of the TicTacToeView class.
     * The test sets up a game board with specific symbols and checks if the correct board layout is displayed.
     */
    @Test
    public void testDisplayBoard() {
        // Given
        char[][] board = {
                {'X', 'O', ' '},
                {' ', 'X', ' '},
                {' ', 'O', 'X'}
        };
        String expectedOutput = "   0   1   2  \n" +
                "  +---+---+---+\n" +
                "0 | X | O |   |\n" +
                "  +---+---+---+\n" +
                "1 |   | X |   |\n" +
                "  +---+---+---+\n" +
                "2 |   | O | X |\n" +
                "  +---+---+---+\n";

        // When
        ticTacToeView.displayBoard(board);

        // Then
        Assertions.assertEquals(removeCarriageReturns(expectedOutput), removeCarriageReturns(outputStream.toString()));
    }

    /**
     * Test case to verify the showWinner() method of the TicTacToeView class.
     * The test provides the current player and checks if the correct message for the winner is displayed.
     */
    @Test
    public void testShowWinner() {
        // Given
        char currentPlayer = 'X';
        String expectedOutput = "Player X wins!\n";

        // When
        ticTacToeView.showWinner(currentPlayer);

        // Then
        Assertions.assertEquals(removeCarriageReturns(expectedOutput), removeCarriageReturns(outputStream.toString()));
    }

    /**
     * Test case to verify the showDraw() method of the TicTacToeView class.
     * The test checks if the correct message for a draw game is displayed.
     */
    @Test
    public void testShowDraw() {
        // Given
        String expectedOutput = "It's a draw!\n";

        // When
        ticTacToeView.showDraw();

        // Then
        Assertions.assertEquals(removeCarriageReturns(expectedOutput), removeCarriageReturns(outputStream.toString()));
    }

    /**
     * Test case to verify the showInvalidMove() method of the TicTacToeView class.
     * The test checks if the correct message for an invalid move is displayed.
     */
    @Test
    public void testShowInvalidMove() {
        // Given
        String expectedOutput = "Invalid move! Try again.\n";

        // When
        ticTacToeView.showInvalidMove();

        // Then
        Assertions.assertEquals(removeCarriageReturns(expectedOutput), removeCarriageReturns(outputStream.toString()));
    }

    /**
     * Helper method to remove carriage returns from a string for consistent output comparison.
     *
     * @param input The input string to remove carriage returns from.
     * @return The modified string without carriage returns.
     */
    private String removeCarriageReturns(String input) {
        return input.replaceAll("\r", "");
    }
}
