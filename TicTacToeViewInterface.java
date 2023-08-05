public interface TicTacToeViewInterface {
    void displayBoard(char[][] board);
    int[] getMove(char currentPlayer);
    void showInvalidMove();
    void showWinner(char currentPlayer);
    void showDraw();
}