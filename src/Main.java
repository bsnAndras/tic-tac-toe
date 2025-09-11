import java.util.Scanner;

public class Main {

    public static Board board;

    public static void main(String[] args) {
        boolean wantToPlay = true;
        System.out.println("---- Tic-Tac-Toe Game ----");

        try(Scanner scanner = new Scanner(System.in)) {
            while(wantToPlay){
                game(scanner);

                System.out.println("Do you want to play again? (yes/no)");
                String playAgainResponse = scanner.nextLine().trim().toLowerCase();

                while(!playAgainResponse.matches("^(yes|y|no|n)$")) {
                    System.out.println("Invalid input. Please enter 'yes/y' or 'no/n'.");
                    playAgainResponse = scanner.nextLine().trim().toLowerCase();
                }

                wantToPlay = playAgainResponse.matches("^(yes|y)$");
            }
            System.out.println("Thank you for playing! Goodbye.");
        } catch (Exception e) {
            System.err.println("An exception occurred: " + e.getMessage());
            e.printStackTrace();

            System.out.println("Restarting game due to an error...");
            main(args); // Restart the game on exception
        }
    }

    private static void game(Scanner scanner) {
        board = new Board();
        board.printBoard();
    }
}