package Problems.StandardTicTacToe;

/**
 * Runnable demo of the reference TicTacToe implementation.
 * It plays a short sequence that leads to X winning on the top row.
 */
public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        System.out.println("Starting demo game (no interactive input).");
        game.printBoard();

        // Sequence: X:1, O:5, X:2, O:9, X:3 => X wins (top row)
        int[] moves = {1, 5, 2, 9, 3};
        for (int i = 0; i < moves.length; i++) {
            System.out.println();
            System.out.println("Player " + game.getCurrentPlayer().getSymbol() + " plays cell " + moves[i]);
            GameStatus status = game.playMove(moves[i]);
            game.printBoard();
            if (status == GameStatus.WIN) {
                System.out.println("Result: WIN by " + (i % 2 == 0 ? 'X' : 'O'));
                break;
            } else if (status == GameStatus.DRAW) {
                System.out.println("Result: DRAW");
                break;
            }
        }

        System.out.println();
        System.out.println("Demo finished.");
    }
}
