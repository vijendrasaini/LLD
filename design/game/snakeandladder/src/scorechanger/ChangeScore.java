package design.game.snakeandladder.src.scorechanger;

import design.game.snakeandladder.src.board.Cell;
import design.game.snakeandladder.src.user.User;

public abstract class ChangeScore {
    public void change(Cell target, User user) {
        user.getToken().setCell(target);
    }
}
