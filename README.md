# TicTacToe Game
### AI Assisted Assignment for CSC207
This was done on Java 11, tested with JUnit Jupiter API v5

## Summary
### User Story: 

As a player, I want to play Tic-Tac-Toe using the command-line interface provided by the game. Upon starting the game, 
I am presented with a main menu with options to start the game, view and modify symbols for X and O, 
and read instructions on how to play. I choose to start the game, and I am prompted to enter the row and column numbers 
to make my move as Player X. The board is displayed after each move, showing the current state of the game. 
I continue making moves until either I or the opponent (Player O) wins, or the game ends in a draw. 
The game congratulates the winner or announces the draw, and I can choose to play again or exit the game.

### Use Case:

The Player starts the game.
The game displays a main menu with options: Start Game, Options, How to Play, and Exit.
The Player selects "Start Game" from the menu.
The game initializes the board and displays it.
The Player, as "Player X," makes a move by entering row and column numbers.
The game validates the move and updates the board.
The game checks for a win or a draw condition. If none, it switches to "Player O."
Steps 5 to 7 repeat until there is a winner or a draw.
The game displays the result: "Player X wins," "Player O wins," or "It's a draw."
The Player is given the option to play again or exit the game.

## Remaining Code Smells, Violations of CA/SOLID
### Code Smells
Long Method - TicTacToeController.playGame() is a long method that is difficult to fix it has nested if statements 
inside a while loop that calls methods in other classes cause it to be difficult to shorten.

### Violations of CA/SOLID
Clean Architecture - Most CA Violations have been cleared, however Main and MainMenu is very closely bundled. Otherwise,
there should be no violations

SOLID - Does not violate SRP. OCP has been implemented to best of abilities. LSP is not applicable. 
Does not violate ISP, DIP violated has been fixed.