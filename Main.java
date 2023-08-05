import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu();
        TicTacToeUseCase useCase = new TicTacToeUseCase();

        System.out.println("Welcome to Tic-Tac-Toe!");

        while (true) {
            int choice = mainMenu.showMenu();

            if (choice == 1) {
                TicTacToeView view = new TicTacToeView(useCase.getXSymbol(), useCase.getOSymbol());
                TicTacToeController controller = new TicTacToeController(useCase, view);
                controller.playGame();
                useCase.initializeBoard(); // Reset the board for a new game
            } else if (choice == 2) {
                mainMenu.showExitMessage();
                break;
            } else if (choice == 3) {
                mainMenu.showOptions(useCase);
            } else if (choice == 4) {
                mainMenu.showHowToPlay(); // Option to display "How to Play" instructions
            } else {
                mainMenu.showInvalidChoice();
            }
        }

        mainMenu.closeScanner();
    }
}
