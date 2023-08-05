import java.util.Scanner;

/**
 * The main class to run the Tic-Tac-Toe game.
 */
public class Main {
    /**
     * The entry point of the Tic-Tac-Toe game.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        TicTacToeUseCase useCase = new TicTacToeUseCase();

        System.out.println("Welcome to Tic-Tac-Toe!");

        while (true) {
            int choice = mainMenu.showMenu(); // Display the main menu and get the user's choice.

            if (choice == 1) {
                TicTacToeView view = new TicTacToeView(useCase.getXSymbol(), useCase.getOSymbol()); // Create a new view with custom player symbols.
                TicTacToeController controller = new TicTacToeController(useCase, view); // Initialize the game controller with the use case and view.
                controller.playGame(); // Start a new game with the chosen symbols.
                useCase.initializeBoard(); // Reset the board for a new game after the game ends.
            } else if (choice == 2) {
                mainMenu.showExitMessage(); // Display the exit message and terminate the application.
                break;
            } else if (choice == 3) {
                mainMenu.showOptions(useCase); // Display the options menu to modify player symbols.
            } else if (choice == 4) {
                mainMenu.showHowToPlay(); // Display instructions on how to play the game.
            } else {
                mainMenu.showInvalidChoice(); // Display a message for an invalid choice.
            }
        }

        mainMenu.closeScanner(); // Close the scanner used for user input.
    }
}
