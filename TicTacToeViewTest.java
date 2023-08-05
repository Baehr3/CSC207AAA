import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TicTacToeViewTest {
    private TicTacToeView ticTacToeView;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        ticTacToeView = new TicTacToeView('X', 'O');
        System.setOut(new PrintStream(outputStream));
    }

    private String removeCarriageReturns(String input) {
        return input.replaceAll("\r", "");
    }

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

    @Test
    public void testShowDraw() {
        // Given
        String expectedOutput = "It's a draw!\n";

        // When
        ticTacToeView.showDraw();

        // Then
        Assertions.assertEquals(removeCarriageReturns(expectedOutput), removeCarriageReturns(outputStream.toString()));
    }

    @Test
    public void testShowInvalidMove() {
        // Given
        String expectedOutput = "Invalid move! Try again.\n";

        // When
        ticTacToeView.showInvalidMove();

        // Then
        Assertions.assertEquals(removeCarriageReturns(expectedOutput), removeCarriageReturns(outputStream.toString()));
    }
}
