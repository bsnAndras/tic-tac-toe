# Project specifications

## Overview
- programming language: Java
- user interface: CLI (Command Line Interface)

## Project Structure
### Models and Data Structures
- Player enum (X,O): Represents a player in the game or the state of a cell (X, O, null).

### Methods
- main(): Entry point of the application. Responsible for initializing, restarting and terminating the game.
- game(): Contains the main game loop, handling player turns and checking for win/draw conditions.
- printBoard(): Displays the current state of the game board.
- makeMove(int row, int col): Places a player's mark on the board at the specified position.
- checkWin(): Checks if the current player has won the game.
- checkDraw(): Checks if the game has ended in a draw.
- switchPlayer(): Switches the current player from X to O or O to X.