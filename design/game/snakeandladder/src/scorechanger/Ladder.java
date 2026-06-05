package design.game.snakeandladder.src.scorechanger;

import design.game.snakeandladder.src.board.Cell;
import design.game.snakeandladder.src.user.User;

public class Ladder extends ChangeScore{
    private Cell base;
    private Cell top;

    public Ladder(Cell base, Cell top) {
        this.base = base;
        this.top = top;
    }

    public void climb(User user) {
        System.out.println("USER : %d is taking jump to : (%d, %d)".formatted(user.getToken().getId(), this.top.getPosX(), this.top.getPosY()));
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Thread intrupped ");
        }
        change(this.top, user);
    }

    public boolean isBaseCell(Cell cell) {
        return cell == this.base;
    }

    public Cell getTopCell() {
        return this.top;
    }
}
