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
        board.printBoard();

        int i = 9; //simple iteration for checking for draw
        while (i-- > 0) {
            System.out.printf("Player %s's turn: %n", player.name());
            int[] cellPosition = new int[2]; //coordinates in board (1-3): [x,y]
            do {
                cellPosition[1] = getValidatedInput(() -> {
                    System.out.print("Select a row (1-3): ");
                    return Integer.parseInt(scanner.nextLine());
                }, input -> input > 0 && input < 4);
                cellPosition[0] = getValidatedInput(() -> {
                    System.out.print("Select a column (1-3): ");
                    return Integer.parseInt(scanner.nextLine());
                }, input -> input > 0 && input < 4);
            } while (isCellOccupied(cellPosition));

            board.setCell(player, cellPosition[0], cellPosition[1]);
            board.printBoard();

            if (checkForWin(cellPosition[0], cellPosition[1])) {
                System.out.println("-------------------------------");
                System.out.printf("||-||   Player %s wins.    ||-||%n", player);
                System.out.println("-------------------------------");
                return;
            }

            player = player.switchPlayer();
        }

        System.out.println("-------------------------------");
        System.out.println("||-||    It is a draw.    ||-||");
        System.out.println("-------------------------------");
    }

    public static boolean checkForWin(int x, int y) {
        Player player = board.getCell(x, y);

        //horizontal
        int attempt = dfs(x - 1, y, new int[]{-1, 0}, player);
        if(attempt > -1 &&
           (attempt > 1 || attempt + dfs(x + 1, y, new int[]{1, 0}, player) > 1))
            return true;

        //vertical
        attempt = dfs(x, y - 1, new int[]{0, -1}, player);
        if(attempt > -1 &&
           (attempt > 1 || attempt + dfs(x, y + 1, new int[]{0, 1}, player) > 1))
            return true;

        //diagonals
        if(x == 2 && y != 2 ||
           x != 2 && y == 2)
            return false; //these places are in the middle of a side, so cannot win with diagonal

        //diagonal 1
        attempt = dfs(x - 1, y - 1, new int[]{-1, -1}, player);
        if(attempt > -1 &&
           (attempt > 1 || attempt + dfs(x + 1, y + 1, new int[]{1, 1}, player) > 1))
            return true;

        //diagonal 2
        attempt = dfs(x + 1, y - 1, new int[]{1, -1}, player);
        if(attempt > -1 &&
           (attempt > 1 || attempt + dfs(x - 1, y + 1, new int[]{-1, 1}, player) > 1))
            return true;

        return false;
    }

    private static int dfs(int x, int y, int[] direction, Player player) {
        if (x < 1 || x > 3 || y < 1 || y > 3)
            return 0;
        if (!board.getCell(x, y).equals(player))
            return -1;

        int forward = dfs(x + direction[0], y + direction[1], direction, player);
        if (forward < 0)
            return -1;

        return forward + 1;
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