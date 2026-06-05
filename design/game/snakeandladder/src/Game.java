package design.game.snakeandladder.src;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import design.game.snakeandladder.src.board.Board;
import design.game.snakeandladder.src.scorechanger.Ladder;
import design.game.snakeandladder.src.scorechanger.Snake;
import design.game.snakeandladder.src.user.Token;
import design.game.snakeandladder.src.user.User;

public class Game {
    private Board board;
    private Deque<User> trunManagerQueue;
    private User user1;
    private User user2;
    public void makeSetup() {

        // board setup;
        Board board = new Board(6, 6);

        Snake snake1 = new Snake(board.getCell(11), board.getCell(3));
        Snake snake2 = new Snake(board.getCell(23), board.getCell(5));
        Snake snake3 = new Snake(board.getCell(33), board.getCell(25));

        board.addSnake(snake1);
        board.addSnake(snake2);
        board.addSnake(snake3);


        Ladder ladder1 = new Ladder(board.getCell(1), board.getCell(14));
        Ladder ladder2 = new Ladder(board.getCell(3), board.getCell(16));
        Ladder ladder3 = new Ladder(board.getCell(21), board.getCell(27));
        Ladder ladder4 = new Ladder(board.getCell(29), board.getCell(36));

        board.addLadder(ladder1);
        board.addLadder(ladder2);
        board.addLadder(ladder3);
        board.addLadder(ladder4);

        
        // user setup
        Token token1 = new Token(1, board.getCell(1));
        Token token2 = new Token(2, board.getCell(1));

        this.user1 = new User(token1, board);
        this.user2 = new User(token2, board);

        this.trunManagerQueue = new ArrayDeque<>();
        this.trunManagerQueue.offer(user1);
        this.trunManagerQueue.offer(user2);
        this.board = board;
    }

    public void start() {
        User winner = null;
        boolean isDraw = false;
        
        while (winner == null && !isDraw) {
            System.out.println("Enter 1 : Play Move");
            System.out.println("Enter 2 : End the Game");
            System.out.print("Enter ( 1 / 2 ) : ");
            try(Scanner scanner = new Scanner(System.in)) {
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        playMove();
                        break;
                    case 2:
                        System.out.println("Exit !!");
                        return;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Terminal Closed !!");
                System.exit(0);
            } 
            winner = user1;
        }

        if(winner != null) {
            System.out.println("Winner user Id : " + winner.getToken().getId());
        } else if(isDraw) {
            System.out.println("Game has been Drawwwwwwwn!!!!");
        }
    }

    void playMove() {
        User user = this.trunManagerQueue.poll();
        System.out.println("User with Token ID : " + user.getToken().getId() + " is playing ....");

        user.play();
    }
}
