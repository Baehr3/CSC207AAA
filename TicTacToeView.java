import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The TicTacToeView class is responsible for displaying the Tic-Tac-Toe game board and interacting with the user.
 * It implements the Observer interface to receive updates from the TicTacToeUseCase when the game board changes.
 * It also implements the TicTacToeViewInterface to define methods required by the view.
 */
public class TicTacToeView implements Observer, TicTacToeViewInterface {
    private char xSymbol;
    private char oSymbol;

    /**
     * Constructs a TicTacToeView with custom X and O symbols.
     *
     * @param xSymbol The char representing the custom X symbol.
     * @param oSymbol The char representing the custom O symbol.
     */
    public TicTacToeView(char xSymbol, char oSymbol) {
        this.xSymbol = xSymbol;
        this.oSymbol = oSymbol;
    }

    /**
     * Displays the current game board on the screen.
     *
     * @param board The 2D array representing the game board.
     */
    public void displayBoard(char[][] board) {
        System.out.println("   0   1   2  ");
        System.out.println("  +---+---+---+");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("  +---+---+---+");
        }
    }

    /**
     * Updates the view with the new game board state.
     *
     * @param board The updated 2D array representing the game board.
     */
    public void update(char[][] board) {
        displayBoard(board);
    }

    /**
     * Shows a message indicating the winner of the game.
     *
     * @param currentPlayer The char representing the winning player (either 'X' or 'O').
     */
    public void showWinner(char currentPlayer) {
        System.out.println("Player " + currentPlayer + " wins!");
    }

    /**
     * Displays a message indicating the game ended in a draw.
     */
    public void showDraw() {
        System.out.println("It's a draw!");
    }

    /**
     * Gets the player's move (row and column indices) from the user.
     *
     * @param currentPlayer The char representing the current player (either 'X' or 'O').
     * @return An array of two integers representing the row and column indices of the player's move.
     */
    public int[] getMove(char currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player " + currentPlayer + ", enter row (0-2) and column (0-2) separated by space: ");
        try {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            return new int[]{row, col};
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
            return getMove(currentPlayer); // Retry if input is invalid
        }
    }

    /**
     * Shows a message indicating an invalid move.
     */
    public void showInvalidMove() {
        System.out.println("Invalid move! Try again.");
    }
}
