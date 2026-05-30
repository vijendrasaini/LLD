package Problems.StandardTicTacToe;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Board manages cells, placement and undo history. It has no UI.
 */
public class Board {
    private final char[][] cells;
    private final int rows;
    private final int columns;
    private final Deque<Move> history = new ArrayDeque<>();

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.cells = new char[rows][columns];
        reset();
    }

    public void reset() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = ' ';
            }
        }
        history.clear();
    }

    public boolean isValidCell(int cell) {
        return cell > 0 && cell <= rows * columns;
    }

    public int[] calculateCellIndexes(int pos) {
        return new int[]{(pos - 1) / columns, (pos - 1) % columns};
    }

    public boolean isCellEmpty(int cell) {
        int[] p = calculateCellIndexes(cell);
        return cells[p[0]][p[1]] == ' ';
    }

    /** Place a move for symbol at cell. Returns true if placed. */
    public boolean placeMove(char symbol, int cell) {
        if (!isValidCell(cell)) return false;
        if (!isCellEmpty(cell)) return false;
        int[] p = calculateCellIndexes(cell);
        cells[p[0]][p[1]] = symbol;
        history.push(new Move(symbol, p[0], p[1]));
        return true;
    }

    /** Undo last move; returns the undone Move or null if none. */
    public Move undoLastMove() {
        if (history.isEmpty()) return null;
        Move m = history.pop();
        cells[m.getRow()][m.getCol()] = ' ';
        return m;
    }

    public boolean isFull() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (cells[i][j] == ' ') return false;
            }
        }
        return true;
    }

    /** Checks rows, columns and both diagonals for a winner. Returns ' ' if none. */
    public char checkWinner() {
        // rows
        for (int i = 0; i < rows; i++) {
            char first = cells[i][0];
            if (first == ' ') continue;
            boolean win = true;
            for (int j = 1; j < columns; j++) {
                if (cells[i][j] != first) { win = false; break; }
            }
            if (win) return first;
        }

        // columns
        for (int j = 0; j < columns; j++) {
            char first = cells[0][j];
            if (first == ' ') continue;
            boolean win = true;
            for (int i = 1; i < rows; i++) {
                if (cells[i][j] != first) { win = false; break; }
            }
            if (win) return first;
        }

        // diagonal top-left -> bottom-right
        char first = cells[0][0];
        if (first != ' ') {
            boolean win = true;
            for (int i = 1; i < rows; i++) {
                if (cells[i][i] != first) { win = false; break; }
            }
            if (win) return first;
        }

        // diagonal top-right -> bottom-left
        first = cells[0][columns - 1];
        if (first != ' ') {
            boolean win = true;
            for (int i = 1; i < rows; i++) {
                if (cells[i][columns - 1 - i] != first) { win = false; break; }
            }
            if (win) return first;
        }

        return ' ';
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < columns; j++) {
                sb.append(cells[i][j] == ' ' ? '-' : cells[i][j]);
                if (j < columns - 1) sb.append(' ');
            }
            System.out.println(sb.toString());
        }
    }
}
