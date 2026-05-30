package Problems.StandardTicTacToe;

/** Simple Player holder: symbol and score. */
public class Player {
    private final char symbol;
    private int score;

    public Player(char symbol) {
        this.symbol = symbol;
        this.score = 0;
    }

    public char getSymbol() { return symbol; }
    public int getScore() { return score; }
    public void incrementScore() { score++; }
}
