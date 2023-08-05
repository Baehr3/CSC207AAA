/**
 * The Observer interface for observing changes in the Tic-Tac-Toe board.
 */
public interface Observer {
    /**
     * Called when the observed Tic-Tac-Toe board is updated.
     *
     * @param board The updated Tic-Tac-Toe board represented as a 2D char array.
     */
    void update(char[][] board);
}
