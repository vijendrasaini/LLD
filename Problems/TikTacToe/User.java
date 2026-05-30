package Problems.TikTacToe;

class User {
    private char userId;
    private int totalMove;
    private int wonInnings;

    public User(char userId, int totalMove) {

        this.userId = userId;
        this.totalMove = totalMove;
    }

    public char getUserId() {
        return userId;
    }

    public void setUserId(char userId) {
        this.userId = userId;
    }

    public int getTotalMove() {
        return totalMove;
    }

    public void setTotalMove(int totalMove) {
        this.totalMove = totalMove;
    }

    public int getWonInnings() {
        return wonInnings;
    }

    public void setWonInnings(int wonInnings) {
        this.wonInnings = wonInnings;
    }
}
