import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static Board board;

    public static void main(String[] args) {
        boolean wantToPlay = true;
        System.out.println("---- Tic-Tac-Toe Game ----");

        try (Scanner scanner = new Scanner(System.in)) {
            while (wantToPlay) {
                game(scanner);

                System.out.println("Do you want to play again? (yes/no)");
                String playAgainResponse = scanner.nextLine().trim().toLowerCase();

                while (!playAgainResponse.matches("^(yes|y|no|n)$")) {
                    System.out.println("Invalid input. Please enter 'yes/y' or 'no/n'.");
                    playAgainResponse = scanner.nextLine().trim().toLowerCase();
                }

                wantToPlay = playAgainResponse.matches("^(yes|y)$");
            }
            System.out.println("Thank you for playing! Goodbye.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void game(Scanner scanner) {
        board = new Board();
        Player player = Player.X;

        int i = 3; //simple iteration for testing
        do {
            board.printBoard();
            System.out.printf("Player %s's turn: %n", player.name());
            int[] cell = new int[2];
            do {
                cell[0] = getValidatedInput(() -> {
                    System.out.print("Select a row (1-3): ");
                    return Integer.parseInt(scanner.nextLine());
                }, input -> input > 0 && input < 4);
                cell[1] = getValidatedInput(() -> {
                    System.out.print("Select a column (1-3): ");
                    return Integer.parseInt(scanner.nextLine());
                }, input -> input > 0 && input < 4);
            } while (isCellOccupied(cell));

            board.setCell(player, cell[0], cell[1]);
            player = player.switchPlayer();
        } while (i-- > 0);

        board.printBoard();
    }

    private static boolean isCellOccupied(int[] cell) {
        if (board.getCell(cell[0], cell[1]).equals(Player.EMPTY))
            return false;

        System.out.println("Selected cell is occupied. Select another one!");
        return true;
    }

    private static <I> I getValidatedInput(Supplier<I> inputExecutor, Predicate<I> inputValidator) {
        I input;
        input = inputExecutor.get();

        while (!inputValidator.test(input)) {
            System.out.println("Invalid input. Try again!");
            input = inputExecutor.get();
        }

        return input;
    }
}