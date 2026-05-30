package TikTacToe;

import java.util.Scanner;

class BuildTheGame {
    private static User userO;
    private static User userX;
    private static Board board;
    private static Scanner scanner = new Scanner(System.in);

    public static void setup() {
        userO = new User('O', 0);
        userX = new User('X', 0);

        board = new Board(3, 3, userO, userX);
    }

    public static void start() {
        setup();
        board.addInning(new Inning(' ', InningStatus.HALDTED));

        System.out.println("Game has been started. Let's band now!!!!!");
        System.out.println("Menu : ");
        System.out.println("Enter 1 : To play next move");
        System.out.println("Enter 2 : To revert / Undo the Move");
        System.out.println("Enter 3 : Exit");

        while (true) {
            System.out.println();
            board.showTheBoard();
            board.getMoves();
            System.out.print("( User - " + board.getCurrentUserPlayingType() + " ) Please enter the input : ");
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    commandPlayNextMove();
                    break;
                case 2:
                    commandUndoMove();
                    break;
                case 3:
                    commandTerminateTheGame();
                    break;
                default:
                    processInvalidInput();
                    break;
            }
        }
    }

    public static void commandPlayNextMove() {
        System.out.println("Please enter the Cell pos [1,9] : ");
        int cell = scanner.nextInt();
        if(cell < 1 || cell > 9) {
            System.out.println("Invalid input. Should be [1,9]");
            return;
        }

        int[] pos = board.calculateCellIndexes(cell);
        if(board.isMovePlayedForTheCell(pos[0], pos[1])) {
            System.out.println("Kya aap such me andhe h ? Aapko dikhayi nhi deta .... ? ");
            return;
        }

        board.playTheMove(pos[0], pos[1]);
        System.out.println("X : %d, Y : %d".formatted(pos[0], pos[1]));
    }

    public static void commandUndoMove() {
        System.out.print("Are you sure you want to undo ? (0/1) : ");
        int undoConfirmation = scanner.nextInt();
        if (undoConfirmation == 1) {
            board.undoLastMove();
        }
    }

    public static void commandTerminateTheGame() {
        System.out.print("Are you sure you want to terminate ? (0/1) : ");
        int confirmation = scanner.nextInt();
        if (confirmation == 1) {
            System.out.println();
            System.out.println("Game is terminated. Hope you enjoyed. Thanks !!!");
            scanner.close();
            System.exit(confirmation);
        }
    }

    public static void processInvalidInput() {
        System.out.println("Invalid Input!!!!");
    }
}
