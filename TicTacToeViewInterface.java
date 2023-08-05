/**
 * The TicTacToeViewInterface interface defines the contract for a view in the Tic-Tac-Toe game.
 * Implementing classes should provide methods to display the game board, get player moves,
 * show messages for invalid moves, game winner, and draw scenarios.
 */
public interface TicTacToeViewInterface {
    /**
     * Displays the current game board on the screen.
     *
     * @param board The 2D array representing the game board.
     */
    void displayBoard(char[][] board);

    /**
     * Gets the player's move (row and column indices) from the user.
     *
     * @param currentPlayer The char representing the current player (either 'X' or 'O').
     * @return An array of two integers representing the row and column indices of the player's move.
     */
    int[] getMove(char currentPlayer);

    /**
     * Shows a message indicating that the player's move is invalid.
     */
    void showInvalidMove();

    /**
     * Displays a message announcing the winner of the game.
     *
     * @param currentPlayer The char representing the player who won (either 'X' or 'O').
     */
    void showWinner(char currentPlayer);

    /**
     * Displays a message indicating that the game has ended in a draw.
     */
    void showDraw();
}
