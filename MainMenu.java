import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    private Scanner scanner;

    public MainMenu() {
        scanner = new Scanner(System.in);
    }

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

    public void showInvalidChoice() {
        System.out.println("Invalid choice. Please select a valid option.");
    }

    public void showHowToPlay() {
        System.out.println("How to Play Tic-Tac-Toe:");
        System.out.println("1. The game is played on a 3x3 grid.");
        System.out.println("2. Players take turns to place their symbol (X or O) in an empty cell.");
        System.out.println("3. The first player to get three of their symbols in a row, column, or diagonal wins.");
    }

    public void showExitMessage() {
        System.out.println("Thank you for playing!");
    }

    public void closeScanner() {
        scanner.close();
    }
}
