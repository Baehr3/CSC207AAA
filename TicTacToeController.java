public class TicTacToeController {
    private TicTacToeUseCase useCase;
    private TicTacToeViewInterface view;

    public TicTacToeController(TicTacToeUseCase useCase, TicTacToeViewInterface view) {
        this.useCase = useCase;
        this.view = view;
        useCase.addObserver((Observer) this.view); // Add the view as an observer to the use case
    }

    // Modify playGame() to use the interface methods
    public void playGame() {
        System.out.println("Welcome to Tic-Tac-Toe!");
        while (true) {
            view.displayBoard(useCase.getBoard());
            int[] move = view.getMove(useCase.getCurrentPlayer());
            if (useCase.makeMove(move[0], move[1])) {
                if (useCase.checkWin()) {
                    view.displayBoard(useCase.getBoard());
                    view.showWinner(useCase.getCurrentPlayer());
                    break;
                } else if (useCase.isBoardFull()) {
                    view.displayBoard(useCase.getBoard());
                    view.showDraw();
                    break;
                } else {
                    useCase.switchPlayer();
                }
            } else {
                view.showInvalidMove();
            }
        }
    }
}
