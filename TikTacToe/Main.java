package TikTacToe;

public class Main {
    
}


class User {
    private String name;
    private int totalMove;

    public User(String name, int totalMove) {

        this.name = name;
        this.totalMove = totalMove;
    }

    public String getName() {
        return this.name;
    }

    public void playNextMove() {

    }

    public void changeTheMove() {

    }
}

class Board {
    private char[][] board;
    private int rows;
    private int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        this.board = new char[this.rows][this.columns];
        resetTheBoard();
    }

    public void processResult() {

    }

    public void resetTheBoard() {
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.rows; j++) {
                this.board[i][j] = ' ';
            }
        }
    }

    public void showTheBoard() {
        
    }
}

class BuildTheGame {
    private static User user1;
    private static User user2;
    private static Board board;
    public static void setup() {
        user1 = new User("User-1", 0);
        user2 = new User("User-2", 0);

        board = new Board(3, 3);
    }
    public start() {

    }
}