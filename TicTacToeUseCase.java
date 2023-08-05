import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The TicTacToeUseCase class represents the game logic and data for the Tic-Tac-Toe game.
 * It manages the game board, player symbols, current player, and checks for win/draw conditions.
 */
public class TicTacToeUseCase {
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY = ' ';
    private List<Observer> observers = new ArrayList<>();
    private char[][] board;
    private char currentPlayer;
    private char xSymbol; // Stores the custom X symbol
    private char oSymbol; // Stores the custom O symbol

    /**
     * Constructs a new TicTacToeUseCase and initializes the game board with empty spaces.
     * By default, 'X' is set as the starting player.
     */
    public TicTacToeUseCase() {
        this.board = new char[BOARD_SIZE][BOARD_SIZE];
        this.xSymbol = 'X';
        this.oSymbol = 'O';
        this.currentPlayer = xSymbol;
        initializeBoard();
    }

    /**
     * Initializes the game board with empty spaces.
     */
    public void initializeBoard() {
        for (char[] row : this.board) {
            Arrays.fill(row, EMPTY);
        }
    }

    /**
     * Gets the current game board.
     *
     * @return The 2D char array representing the game board.
     */
    public char[][] getBoard() {
        return this.board;
    }

    /**
     * Gets the symbol of the current player.
     *
     * @return The char representing the symbol of the current player (either 'X' or 'O').
     */
    public char getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Updates the current player based on the custom X and O symbols provided.
     *
     * @param xSymbol The custom X symbol.
     * @param oSymbol The custom O symbol.
     */
    public void updateCurrentPlayer(char xSymbol, char oSymbol) {
        if (currentPlayer == xSymbol) {
            currentPlayer = oSymbol;
        } else {
            currentPlayer = xSymbol;
        }
    }

    /**
     * Checks if the current player has won the game.
     *
     * @return true if the current player has won, false otherwise.
     */
    public boolean checkWin() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (this.board[i][0] == this.currentPlayer && this.board[i][1] == this.currentPlayer && this.board[i][2] == this.currentPlayer) {
                return true; // Row win
            }
            if (this.board[0][i] == this.currentPlayer && this.board[1][i] == this.currentPlayer && this.board[2][i] == this.currentPlayer) {
                return true; // Column win
            }
        }

        // Check diagonals
        if (this.board[0][0] == this.currentPlayer && board[1][1] == this.currentPlayer && this.board[2][2] == this.currentPlayer) {
            return true; // Main diagonal win
        }
        if (this.board[0][2] == this.currentPlayer && this.board[1][1] == this.currentPlayer && this.board[2][0] == this.currentPlayer) {
            return true; // Anti-diagonal win
        }

        return false;
    }

    /**
     * Sets the game board with a custom configuration for testing purposes.
     *
     * @param board The 2D array representing the game board to set.
     * @throws IllegalArgumentException if the provided board is not of size 3x3.
     */
    public void setBoard(char[][] board) {
        if (board.length == BOARD_SIZE && board[0].length == BOARD_SIZE) {
            this.board = board;
        } else {
            throw new IllegalArgumentException("Invalid board size. The board must be a 3x3 array.");
        }
    }

    /**
     * Checks if the game board is full, indicating a draw.
     *
     * @return true if the board is full, false otherwise.
     */
    public boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (this.board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Gets the custom X symbol.
     *
     * @return The char representing the custom X symbol.
     */
    public char getXSymbol() {
        return this.xSymbol;
    }

    /**
     * Sets the custom X symbol.
     *
     * @param xSymbol The char representing the custom X symbol to set.
     */
    public void setXSymbol(char xSymbol) {
        this.xSymbol = xSymbol;
    }

    /**
     * Gets the custom O symbol.
     *
     * @return The char representing the custom O symbol.
     */
    public char getOSymbol() {
        return this.oSymbol;
    }

    /**
     * Sets the custom O symbol.
     *
     * @param oSymbol The char representing the custom O symbol to set.
     */
    public void setOSymbol(char oSymbol) {
        this.oSymbol = oSymbol;
    }

    /**
     * Switches the current player between 'X' and 'O'.
     */
    public void switchPlayer() {
        this.currentPlayer = (this.currentPlayer == this.xSymbol) ? this.oSymbol : this.xSymbol;
    }

    /**
     * Adds an observer to the list of observers.
     *
     * @param observer The Observer instance to add.
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the list of observers.
     *
     * @param observer The Observer instance to remove.
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all registered observers about changes in the game board.
     */
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(board);
        }
    }

    /**
     * Makes a move on the game board at the specified row and column.
     * The move is only valid if the cell is empty and the row and column indices are within the board boundaries.
     *
     * @param row The row index of the move.
     * @param col The column index of the move.
     * @return true if the move is valid and made successfully, false otherwise.
     */
    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE || board[row][col] != EMPTY) {
            return false; // Invalid move
        }
        board[row][col] = currentPlayer; // Update the board with the current player's symbol
        notifyObservers(); // Notify observers after each move
        return true;
    }
}
