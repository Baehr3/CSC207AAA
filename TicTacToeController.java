/**
 * The TicTacToeController class responsible for controlling the Tic-Tac-Toe game flow.
 */
public class TicTacToeController {
    private TicTacToeUseCase useCase;
    private TicTacToeViewInterface view;

    /**
     * Constructs a new TicTacToeController with the provided TicTacToeUseCase and TicTacToeViewInterface instances.
     *
     * @param useCase The TicTacToeUseCase instance representing the game logic and data.
     * @param view The TicTacToeViewInterface instance for displaying the game board and interacting with the user.
     */
    public TicTacToeController(TicTacToeUseCase useCase, TicTacToeViewInterface view) {
        this.useCase = useCase;
        this.view = view;
        useCase.addObserver((Observer) this.view); // Add the view as an observer to the use case
    }

    /**
     * Plays the Tic-Tac-Toe game, controlling the game flow and user interactions.
     * The method displays the game board, prompts the current player for their move, and checks for a win or draw condition.
     * If the game is not yet over, it switches the current player and continues until there is a winner or a draw.
     */
    public void playGame() {
        while (true) {
            view.displayBoard(useCase.getBoard()); // Display the current game board using the view interface.
            int[] move = view.getMove(useCase.getCurrentPlayer()); // Get the move coordinates from the view.
            if (useCase.makeMove(move[0], move[1])) { // Try to make the move on the board.
                if (useCase.checkWin()) { // Check if the current player has won.
                    view.displayBoard(useCase.getBoard()); // Display the final game board.
                    view.showWinner(useCase.getCurrentPlayer()); // Show the winner message using the view interface.
                    break; // Exit the loop as the game is over.
                } else if (useCase.isBoardFull()) { // Check if the board is full and it's a draw.
                    view.displayBoard(useCase.getBoard()); // Display the final game board.
                    view.showDraw(); // Show the draw message using the view interface.
                    break; // Exit the loop as the game is over.
                } else {
                    useCase.switchPlayer(); // Switch to the next player for the next move.
                }
            } else {
                view.showInvalidMove(); // Show the invalid move message using the view interface.
            }
        }
    }
}
