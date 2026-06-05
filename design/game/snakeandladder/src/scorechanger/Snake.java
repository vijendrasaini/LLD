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
        System.out.println("Snakes bites to User : %d and sending now at POSITION : (%d, %d)".formatted(user.getToken().getId(), this.tail.getPosX(), this.tail.getPosY()));
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Thread intrupped ");
        }
        change(this.tail, user);
    }

    public boolean isHeadCell(Cell cell) {
        return cell == this.head;
    }

    public Cell getTailCell() {
        return this.tail;
    }
}
