import java.util.Scanner;

public class TicTacToeView implements Observer, TicTacToeViewInterface {
    private char xSymbol;
    private char oSymbol;

    public TicTacToeView(char xSymbol, char oSymbol) {
        this.xSymbol = xSymbol;
        this.oSymbol = oSymbol;
    }

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

    public void update(char[][] board) {
        displayBoard(board);
    }

    public void showWinner(char currentPlayer) {
        System.out.println("Player " + currentPlayer + " wins!");
    }

    public void showDraw() {
        System.out.println("It's a draw!");
    }

    public int[] getMove(char currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player " + currentPlayer + ", enter row (0-2) and column (0-2) separated by space: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
    }

    public void showInvalidMove() {
        System.out.println("Invalid move! Try again.");
    }
}
