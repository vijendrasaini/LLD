package design.game.snakeandladder.src.scorechanger;

import design.game.snakeandladder.src.board.Cell;
import design.game.snakeandladder.src.user.User;

public class Snake extends ChangeScore{
    private Cell head;
    private Cell tail;

    public Snake(Cell head, Cell tail) {
        this.head = head;
        this.tail = tail;
    }

    public Cell getTail() {
        return tail;
    }

    public void bites(User user) {
        change(this.tail, user);
    }

    public boolean isHeadCell(Cell cell) {
        return cell == this.head;
    }
}
