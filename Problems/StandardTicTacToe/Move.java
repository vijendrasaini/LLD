package Problems.StandardTicTacToe;

/** Simple value object for a move on the board. */
public class Move {
    private final char player;
    private final int row;
    private final int col;

    public Move(char player, int row, int col) {
        this.player = player;
        this.row = row;
        this.col = col;
    }

    public char getPlayer() { return player; }
    public int getRow() { return row; }
    public int getCol() { return col; }
}
