package design.game.snakeandladder.src.user;

import design.game.snakeandladder.src.board.Board;
import design.game.snakeandladder.src.moveprovider.Dice;

public class User {
    private Token token;
    private Board board;
    public User(Token token, Board board) {
        this.token = token;
        this.board = board;
    }

    public Token getToken() {
        return token;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void play() {
        // Roll the Dice
        System.out.println("Rolling the Dice ...");
        try {
            Thread.sleep(1000); // this is just for fun ( it woun't be in interview or production )
        } catch (Exception e) {
            System.out.println("Thread intruppted!!!");
        }

        int diceResult = new Dice().get();
        System.out.println("Dice result : " + diceResult);

        // let's walk the move on the board.
        moveToken(diceResult);
    }

    private void moveToken(int byStep) {
        board.walkTheToken(this, byStep);
    }
}
