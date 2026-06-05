package design.game.snakeandladder.src.user;

import design.game.snakeandladder.src.board.Cell;

public class Token {
    private Cell cell;
    private int id;
    public Token(int id, Cell cell) {
        this.id = id;
        this.cell = cell;
    }

    public int getId() {
        return id;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
