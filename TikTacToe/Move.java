package TikTacToe;

class Move {
    private char userId;
    private int x;
    private int y;
    private char playedMove;
    public Move(char userId, int x, int y, char playedMove) {
        this.userId = userId;
        this.x = x;
        this.y = y;
        this.playedMove = playedMove;
    }
    public char getUserId() {
        return userId;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public char getPlayedMove() {
        return playedMove;
    }

    
}
