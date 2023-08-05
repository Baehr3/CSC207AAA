import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The class responsible for displaying the main menu and handling user input.
 */
public class MainMenu {
    private Scanner scanner;

    /**
     * Constructs a new MainMenu object and initializes the scanner for user input.
     */
    public MainMenu() {
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu options and waits for the user to make a choice.
     *
     * @return The user's choice as an integer.
     */
    public int showMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
        System.out.println("3. Options");
        System.out.println("4. How to Play"); // New option for "How to Play"
        try {
            int choice = scanner.nextInt();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Consume the invalid input
            return -1; // Return an invalid choice
        }
    }

    /**
     * Displays the options menu and allows the user to modify player symbols.
     *
     * @param useCase The TicTacToeUseCase instance to update player symbols.
     */
    public void showOptions(TicTacToeUseCase useCase) {
        System.out.println("Options:");
        System.out.println("Current X Symbol: " + useCase.getXSymbol());
        System.out.println("Current O Symbol: " + useCase.getOSymbol());
        System.out.println("Enter new X Symbol: ");
        try {
            char newXSymbol = scanner.next().charAt(0);
            System.out.println("Enter new O Symbol: ");
            char newOSymbol = scanner.next().charAt(0);
            useCase.setXSymbol(newXSymbol);
            useCase.setOSymbol(newOSymbol);
            useCase.updateCurrentPlayer(newXSymbol, newOSymbol); // Update currentPlayer
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Invalid input for symbols. Using default symbols.");
        }
    }

    /**
     * Displays a message for an invalid menu choice made by the user.
     */
    public void showInvalidChoice() {
        System.out.println("Invalid choice. Please select a valid option.");
    }

    /**
     * Displays instructions on how to play Tic-Tac-Toe.
     */
    public void showHowToPlay() {
        System.out.println("How to Play Tic-Tac-Toe:");
        System.out.println("1. The game is played on a 3x3 grid.");
        System.out.println("2. Players take turns to place their symbol (X or O) in an empty cell.");
        System.out.println("3. The first player to get three of their symbols in a row, column, or diagonal wins.");
    }

    /**
     * Displays an exit message when the player chooses to exit the game.
     */
    public void showExitMessage() {
        System.out.println("Thank you for playing!");
    }

    /**
     * Closes the scanner used for user input.
     */
    public void closeScanner() {
        scanner.close();
    }
}
