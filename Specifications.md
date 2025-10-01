# Project specifications

## Overview
- programming language: Java 22
- user interface: CLI (Command Line Interface)
- utilizing: JLine library for enhanced console input handling (see more info here: [Jline Homepage](https://jline.org/))

## Project Structure
### Models and Data Structures
- Player enum (X,O): Represents a player in the game or the state of a cell (X, O, null).
- Board class: Represents the game board, containing a 2D array of Player enums and methods to manipulate and check the board state.
- Main class: Contains the main game logic, including the game loop, player input handling, and win/draw condition checks.

### Core Methods
- main(): Entry point of the application. Responsible for initializing, restarting and terminating the game.
- game(): Contains the main game loop, handling player turns and checking for win/draw conditions.
- switchPlayer(): Switches the current player from X to O or O to X.
- checkForWin(): Checks if the current player has won the game.
- dfs(): Depth-first search algorithm to check for a winning path on the board.
- getValidatedInput(): Handles user input, ensuring valid entries. For invalid inputs, it prompts the user to re-enter.