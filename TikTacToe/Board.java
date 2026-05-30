package TikTacToe;

import java.util.ArrayList;
import java.util.List;

class Board {
    private char[][] board;
    private int rows;
    private int columns;
    private User userPlayingTheMove = null;
    private List<Move> history;
    private User userO;
    private User userX;
    private List<Inning> inningsList;

    public Board(int rows, int columns, User userO, User userX) {
        this.rows = rows;
        this.columns = columns;

        this.board = new char[this.rows][this.columns];
        this.history = new ArrayList<>();
        this.inningsList = new ArrayList<>();

        this.userO = userO;
        this.userX = userX;

        this.userPlayingTheMove = userO; // let's start alway with user-O
        resetTheBoard();
    }

    public char getCurrentUserPlayingType() {
        return this.userPlayingTheMove.getUserId();
    }

    public void addInning(Inning inning) {
        inningsList.add(inning);
    }

    public void processResult() {
        if(!(userO.getTotalMove() == rows || userX.getTotalMove() == columns)) {
            return;
        }

        // Process the board now.
        //1. rows.
        for(int i = 0; i < rows; i++) {
            int moveCountO = 0;
            int moveCountX = 0;
            for(int j = 0; j < columns; j++) {
                if(board[i][j] == 'O') moveCountO++;
                if(board[i][j] == 'X') moveCountX++;
            }

            if(moveCountO == columns) {
                updateDecision('O');
                return;
            }

            if(moveCountX == columns) {
                updateDecision('X');
            }
        }

        // 2. columns
        for(int j = 0; j < rows; j++) {
            int moveCountO = 0;
            int moveCountX = 0;
            for(int i = 0; i < columns; i++) {
                if(board[i][j] == 'O') moveCountO++;
                if(board[i][j] == 'X') moveCountX++;
            }

            if(moveCountO == columns) {
                updateDecision('O');
                return;
            }

            if(moveCountX == columns) {
                updateDecision('X');
            }
        }

        // cross top-left to bottom-right
        int moveCountO = 0;
        int moveCountX = 0;
        for(int i = 0; i < rows; i++) {
            if(board[i][i] == 'O') moveCountO++;
            if(board[i][i] == 'X') moveCountX++;
        }

        if(moveCountO == columns) {
            updateDecision('O');
            return;
        }

        if(moveCountX == columns) {
            updateDecision('X');
        }

        // cross top-right to bottom-left
        moveCountO = 0;
        moveCountX = 0;

        for(int i = 0; i < rows; i++) {
            if(board[i][columns - 1 - i] == 'O') moveCountO++;
            if(board[i][columns - 1 - i] == 'X') moveCountX++;
        }

        if(moveCountO == columns) {
            updateDecision('O');
            return;
        }

        if(moveCountX == columns) {
            updateDecision('X');
        }

        updateDecision(' ');
    }

    public void updateDecision(char winner) {
        Inning ongoingInning = inningsList.getLast();
        ongoingInning.setStatus(InningStatus.COMPLETED);
        ongoingInning.setWonUserType(winner);

        this.resetTheBoard();
        if(winner == ' ') {
            System.out.println("No conclusion. No one has won / lost. You can restart.");
            return;
        }

        User user = winner == 'O' ? userO : userX;
        user.setWonInnings(user.getWonInnings() + 1);
        System.out.println("User-%c has won....".formatted(winner));
        System.out.println("Won matches history : ");
        System.out.println("User-O : " + userO.getWonInnings());
        System.out.println("User-X : " + userX.getWonInnings());
    }

    public void resetTheBoard() {
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.rows; j++) {
                this.board[i][j] = ' ';
            }
        }

        userO.setTotalMove(0);
        userX.setTotalMove(0);
    }

    public void showTheBoard() {
        for(int i = 0; i < rows; i++) {
            StringBuilder str = new StringBuilder("");
            for(int j = 0; j < columns; j++) {
                str.append((board[i][j] == ' ' ? '-' : board[i][j]) + " ");
            }

            System.out.println(str);
        }
    }

    public void setCurrentUserPlayingTheMove(User user) {
        this.userPlayingTheMove = user;
    }

    public void playTheMove(int cell) {
        int[] pos = calculateCellIndexes(cell);
        int x = pos[0], y = pos[1];
        this.userPlayingTheMove.setTotalMove(this.userPlayingTheMove.getTotalMove() + 1);
        char playedMove = userPlayingTheMove.getUserId() == 'O' ? 'O' : 'X';
        board[x][y] = playedMove;
        Move move = new Move(userPlayingTheMove.getUserId(), x, y, playedMove);
        this.userPlayingTheMove = playedMove == 'O' ? userX : userO;
        history.add(move);

        processResult();
    }

    public void undoLastMove() {
        if(history.isEmpty()) {
            System.out.println("No move as of now. Start playing ...!!!");
            return;
        }

        Move lastMove = history.removeLast();
        int row = lastMove.getX(), column = lastMove.getY();
        board[row][column] = ' ';
        User user = lastMove.getUserId() == 'O' ? userO : userX;
        user.setTotalMove(user.getTotalMove() - 1);
        this.userPlayingTheMove = user;
        System.out.println("------------Reverted.--------------");
    }

    public boolean isMovePlayedForTheCell(int cell) {
        int[] pos = calculateCellIndexes(cell);
        return board[pos[0]][pos[1]] != ' ';
    }

    public void getMoves() {
        System.out.println("Total moves played by User-O : "+ userO.getTotalMove());
        System.out.println("Total moves played by User-X : "+ userX.getTotalMove());
    }

    public int[] calculateCellIndexes(int pos) {
        return new int[]{(pos - 1) / 3, (pos - 1) % 3};
    }
}
