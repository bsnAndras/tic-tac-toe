import java.util.Arrays;

public class Board {
    private Player[][] board;

    public Board() {
        this.board = new Player[3][3];
        for (Player[] row : board) {
            Arrays.fill(row, Player.EMPTY);
        }
    }

    public void printBoard() {
        System.out.println("      -------------");
        System.out.printf ("      | %s | %s | %s |%n",board[0][0],board[0][1],board[0][2]);
        System.out.printf ("      -------------%n");
        System.out.printf ("      | %s | %s | %s |%n",board[1][0],board[1][1],board[1][2]);
        System.out.printf ("      -------------%n");
        System.out.printf ("      | %s | %s | %s |%n",board[2][0],board[2][1],board[2][2]);
        System.out.println("      -------------");
    }

    /**
     * Places a player's mark on a selected cell of the board.
     * The coordinates are addressed - in a user-friendly way - from 1 to 3
     * @param player the current player
     * @param x the selected column index (1-3)
     * @param y the selected row index (1-3)
     */
    public void setCell(Player player, int x, int y) {
        board[y-1][x-1] = player;
    }

    /**
     * Returns the Player, whose mark is on the given coordinates.
     * The coordinates are addressed - in a user-friendly way - from 1 to 3
     *
     * @param x the selected column index (1-3)
     * @param y the selected row index (1-3)
     * @return the mark on the selected cell
     */
    public Player getCell(int x, int y) {
        return board[y-1][x-1];
    }
}
