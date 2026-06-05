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

    public void bites(User user) {
        change(tail, user);
    }
}
