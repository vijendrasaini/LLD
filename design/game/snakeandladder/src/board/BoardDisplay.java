package design.game.snakeandladder.src.board;

import java.util.List;

import design.game.snakeandladder.src.scorechanger.Ladder;
import design.game.snakeandladder.src.scorechanger.Snake;
import design.game.snakeandladder.src.user.User;

public class BoardDisplay {
    private List<User> players;
    private Board board;
    public BoardDisplay(List<User> players, Board board) {
        this.players = players;
        this.board = board;
    }

    public void printBoard() {
        System.out.println("\n================================== BOARD VISUALIZATION ==================================");
        
        // Loop backwards from top row to bottom row (e.g., 100 down to 1)
        for (int i = this.board.getRow() - 1; i >= 0; i--) {
            printRowDivider();

            // Determine alternate row direction (Boustrophedon pattern)
            boolean leftToRight = (i % 2 == 0);

            // We render each cell row using 3 structural text lines for maximum clarity
            for (int line = 0; line < 3; line++) {
                if (leftToRight) {
                    for (int j = 0; j < this.board.getColumn(); j++) {
                        printCellLine(i, j, line, players);
                    }
                } else {
                    for (int j = this.board.getColumn() - 1; j >= 0; j--) {
                        printCellLine(i, j, line, players);
                    }
                }
                System.out.println("|"); // Close the line border
            }
        }
        printRowDivider();
        System.out.println("=========================================================================================\n");
    }

    private void printCellLine(int x, int y, int line, List<User> players) {
        Cell cell = this.board.getCellByXAndY(x, y);
        int cellNum = (this.board.getCellIndex(cell)) + 1;

        String content = "";

        switch (line) {
            case 0:
                // Line 1: Cell Number (padded left)
                content = String.valueOf(cellNum);
                System.out.printf("| %-9s", content);
                break;

            case 1:
                // Line 2: Entity Information (Snake Head/Tail or Ladder Base/Top)
                content = getEntityOverlayText(cell, cellNum);
                System.out.printf("| %-9s", content);
                break;

            case 2:
                // Line 3: Player Token Positions
                content = getPlayersOnCellText(cell, players);
                System.out.printf("| %-9s", content);
                break;
        }
    }

    private String getEntityOverlayText(Cell cell, int cellNum) {
        // Scan Snakes
        int i = 0;
        for (Snake snake : this.board.getSnakes()) {
            if (snake.isHeadCell(cell)) {
                return "S%d-HEAD".formatted(i);
            }
            // Note: Ensure your Snake class has a way to verify its tail cell
            // Replace with your exact method name if different (e.g., snake.getTailCell())
            if (cell.equals(snake.getTailCell())) { 
                return "S%d-TAIL".formatted(i);
            }

            i++;
        }

        // Scan Ladders
        i = 0;
        for (Ladder ladder : this.board.getLadders()) {
            if (ladder.isBaseCell(cell)) {
                return "L%d-BASE".formatted(i);
            }
            // Note: Ensure your Ladder class has a way to verify its top cell
            // Replace with your exact method name if different (e.g., ladder.getTopCell())
            if (cell == ladder.getTopCell()) {
                return "L%d-TOP".formatted(i);
            }

            i++;
        }
        return "";
    }

    private String getPlayersOnCellText(Cell cell, List<User> players) {
        StringBuilder sb = new StringBuilder();
        for (User user : players) {
            // Checks if the user's token is currently matching this specific cell instance
            if (user.getToken() != null && cell.equals(user.getToken().getCell())) {
                if (sb.length() > 0) sb.append(",");
                sb.append("U").append(user.getToken().getId()); // e.g., U1, U2
            }
        }
        return sb.toString();
    }

    private void printRowDivider() {
        for (int j = 0; j < this.board.getColumn(); j++) {
            System.out.print("+----------");
        }
        System.out.println("+");
    }
}
