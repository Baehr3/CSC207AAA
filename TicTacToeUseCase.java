import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class TicTacToeUseCase {
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY = ' ';
    private List<Observer> observers = new ArrayList<>();
    private char[][] board;
    private char currentPlayer;
    private char xSymbol; // Stores the custom X symbol
    private char oSymbol; // Stores the custom O symbol

    public TicTacToeUseCase() {
        this.board = new char[BOARD_SIZE][BOARD_SIZE]; // Initialize the board
        this.xSymbol = 'X'; // Default X symbol
        this.oSymbol = 'O'; // Default O symbol
        this.currentPlayer = xSymbol;
        initializeBoard(); // Ensure the board is set to spaces
    }

    public void initializeBoard() {
        for (char[] row : this.board) {
            Arrays.fill(row, EMPTY);
        }
    }

    public char[][] getBoard() {
        return this.board;
    }

    public char getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void updateCurrentPlayer(char xSymbol, char oSymbol) {
        if (currentPlayer == xSymbol) {
            currentPlayer = oSymbol;
        } else {
            currentPlayer = xSymbol;
        }
    }

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
     */
    public void setBoard(char[][] board) {
        if (board.length == BOARD_SIZE && board[0].length == BOARD_SIZE) {
            this.board = board;
        } else {
            throw new IllegalArgumentException("Invalid board size. The board must be a 3x3 array.");
        }
    }

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

    public char getXSymbol() {
        return this.xSymbol;
    }

    public void setXSymbol(char xSymbol) {
        this.xSymbol = xSymbol;
    }

    public char getOSymbol() {
        return this.oSymbol;
    }

    public void setOSymbol(char oSymbol) {
        this.oSymbol = oSymbol;
    }

    public void switchPlayer() {
        this.currentPlayer = (this.currentPlayer == this.xSymbol) ? this.oSymbol : this.xSymbol;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(board);
        }
    }

    // Modify makeMove() to notify observers after each move
    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE || board[row][col] != EMPTY) {
            return false; // Invalid move
        }
        board[row][col] = currentPlayer;
        notifyObservers(); // Notify observers after each move
        return true;
    }

}
