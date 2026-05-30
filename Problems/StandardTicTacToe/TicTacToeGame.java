package Problems.StandardTicTacToe;

/**
 * TicTacToeGame orchestrates players and board. It contains no I/O.
 */
public class TicTacToeGame {
    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private Player current;

    public TicTacToeGame() {
        this.board = new Board(3, 3);
        this.playerX = new Player('X');
        this.playerO = new Player('O');
        this.current = playerX; // X starts
    }

    public Player getCurrentPlayer() { return current; }

    /**
     * Play a move for current player. Returns GameStatus and keeps game state updated.
     */
    public GameStatus playMove(int cell) {
        if (!board.isValidCell(cell)) return GameStatus.INVALID_MOVE;
        if (!board.isCellEmpty(cell)) return GameStatus.INVALID_MOVE;

        board.placeMove(current.getSymbol(), cell);
        char winner = board.checkWinner();
        if (winner != ' ') {
            // update score for the winner
            if (winner == playerX.getSymbol()) playerX.incrementScore(); else playerO.incrementScore();
            return GameStatus.WIN;
        }

        if (board.isFull()) {
            return GameStatus.DRAW;
        }

        // switch turn
        current = (current == playerX) ? playerO : playerX;
        return GameStatus.IN_PROGRESS;
    }

    public boolean undo() {
        Move m = board.undoLastMove();
        if (m == null) return false;
        // set current player to the one who made the undone move
        current = (m.getPlayer() == playerX.getSymbol()) ? playerX : playerO;
        return true;
    }

    public void printBoard() { board.printBoard(); }
    public void reset() { board.reset(); current = playerX; }
}
