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

    void climb(User user) {
        change(top, user);
    }
}
