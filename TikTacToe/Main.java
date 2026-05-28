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
}

class Board {
    private char[][] board;
    private int rows;
    private int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        this.board = new char[this.rows][this.columns];
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
}