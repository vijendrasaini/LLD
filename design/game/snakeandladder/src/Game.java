package design.game.snakeandladder.src;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import design.game.snakeandladder.src.board.Board;
import design.game.snakeandladder.src.board.BoardDisplay;
import design.game.snakeandladder.src.scorechanger.Ladder;
import design.game.snakeandladder.src.scorechanger.Snake;
import design.game.snakeandladder.src.user.Token;
import design.game.snakeandladder.src.user.User;

public class Game {
    private Board board;
    private Deque<User> trunManagerQueue;
    private User user1;
    private User user2;
    private static Scanner scanner = new Scanner(System.in);
    private BoardDisplay display;
    public void makeSetup() {

        // board setup;
        Board board = new Board(6, 6);

        Snake snake1 = new Snake(board.getCell(10), board.getCell(2));
        Snake snake2 = new Snake(board.getCell(22), board.getCell(4));
        Snake snake3 = new Snake(board.getCell(32), board.getCell(24));

        board.addSnake(snake1);
        board.addSnake(snake2);
        board.addSnake(snake3);


        Ladder ladder1 = new Ladder(board.getCell(1), board.getCell(14));
        Ladder ladder2 = new Ladder(board.getCell(3), board.getCell(16));
        Ladder ladder3 = new Ladder(board.getCell(21), board.getCell(27));
        Ladder ladder4 = new Ladder(board.getCell(29), board.getCell(34));

        board.addLadder(ladder1);
        board.addLadder(ladder2);
        board.addLadder(ladder3);
        board.addLadder(ladder4);

        
        // user setup
        Token token1 = new Token(1, board.getCell(0));
        Token token2 = new Token(2, board.getCell(0));

        this.user1 = new User(token1, board);
        this.user2 = new User(token2, board);

        this.trunManagerQueue = new ArrayDeque<>();
        this.trunManagerQueue.offer(user1);
        this.trunManagerQueue.offer(user2);
        this.board = board;

        this.display = new BoardDisplay(List.of(user1, user2), this.board);
    }

    public void start() {
        User winner = null;
        boolean isDraw = false;
        
        while (winner == null && !isDraw) {
            System.out.println("Enter 1 : Play Move");
            System.out.println("Enter 2 : End the Game");
            System.out.println("Enter 3 : Print the boadr");
            System.out.print("Enter ( 1 / 2 / 3 ) : ");
            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        winner = playMove();
                        this.display.printBoard();
                        break;
                    case 2:
                        System.out.println("Exit !!");
                        return;
                    case 3:
                        this.display.printBoard();
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Terminal Closed !!");
                System.exit(0);
            } 
        }

        if(winner != null) {
            System.out.println("Winner user Id : " + winner.getToken().getId());
        } else if(isDraw) {
            System.out.println("Game has been Drawwwwwwwn!!!!");
        }
    }

    public User playMove() {
        User user = this.trunManagerQueue.poll();
        System.out.println("User : " + user.getToken().getId() + " is playing ....");

        User winner = user.play();
        this.trunManagerQueue.add(user); // add it to the last
        return winner;
    }
}
