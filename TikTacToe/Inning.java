package TikTacToe;

class Inning {
    private char wonUserType;
    private InningStatus status;

    public Inning(char wonUserType, InningStatus status) {
        this.wonUserType = wonUserType;
        this.status = status;
    }

    public char getWonUserType() {
        return wonUserType;
    }
    public InningStatus getStatus() {
        return status;
    }
    public void setWonUserType(char wonUserType) {
        this.wonUserType = wonUserType;
    }
    public void setStatus(InningStatus status) {
        this.status = status;
    }
}
