package design.game.snakeandladder.src.board;

import java.util.ArrayList;
import java.util.List;

import design.game.snakeandladder.src.scorechanger.Ladder;
import design.game.snakeandladder.src.scorechanger.Snake;
import design.game.snakeandladder.src.user.User;
import design.game.snakeandladder.src.util.GameMath;

public class Board {
    private List<List<Cell>> board;

    private final int ROW;
    private final int COLUMN;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board(int row, int column) {
        this.ROW = row;
        this.COLUMN = row;

        this.board = buildBoard();
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
    }

    public int getRow() {
        return this.ROW;
    }

    public int getColumn() {
        return this.COLUMN;
    }
    
    public Cell getCellByXAndY(int x, int y) {
        return this.board.get(x).get(y);
    }
    
    public void addSnake(Snake snake) {
        this.snakes.add(snake);
    }

    public void addLadder(Ladder ladder) {
        this.ladders.add(ladder);
    }
    
    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    private List<List<Cell>> buildBoard() {
        List<List<Cell>> board = new ArrayList<>(this.ROW);
        for(int i = 0; i < this.ROW; i++) {

            List<Cell> currentRow = new ArrayList<>(this.COLUMN);
            for(int j = 0; j < this.COLUMN; j++) {
                currentRow.add(new Cell(i, j));
            }
            
            board.add(currentRow);
        }

        return board;
    }

    public Cell getCell(int cellNum) {
        // System.out.println("Query -> cellNUmber : " + cellNum);
        if( cellNum < 0 || cellNum > this.ROW * this.COLUMN - 1) {
            throw new RuntimeException("Invalide Cell Number");
        }

        int[] pos = GameMath.getRowNCol(cellNum, this.COLUMN);
        return this.board.get(pos[0]).get(pos[1]);
    } 

    public Cell getCellByStep(Cell cell, int step) {
        Cell ans = null;
        return ans;
    }

    public int getCellIndex(Cell cell) {
        return this.ROW * cell.getPosX() + cell.getPosY();
    }

    public boolean isStartCell(Cell cell) {
        return cell.getPosX() == 0 && cell.getPosY() == 0;
    }

    public boolean isFinishCell(Cell cell) {
        return cell.getPosX() == this.ROW && cell.getPosY() == this.COLUMN;
    }

    public boolean isLastCell(int cellNum) {
        return this.ROW * this.COLUMN - 1 == cellNum;
    } 

    private boolean isLadderBaseCell(int cellNum) {
        Cell cell = this.getCell(cellNum);

        for(Ladder ladder : ladders) {
            if(ladder.isBaseCell(cell)) return true;
        }

        return false;
    }

    private boolean isSnakeHeadCell(int cellNum) {
        Cell cell = this.getCell(cellNum);

        for(Snake snake : snakes) {
            if(snake.isHeadCell(cell)) return true;
        }

        return false;
    }

    private Snake getSnakeByHeadCell(Cell cell) {
        for (Snake snake : snakes) {
            if(snake.isHeadCell(cell)) return snake;
        }

        return snakes.get(0);
    }

    private Ladder getLadderByBaseCell(Cell cell) {
        for(Ladder ladder : ladders) {
            if(ladder.isBaseCell(cell)) return ladder;
        }

        return ladders.get(0);
    }

    public User walkTheToken(User user, int byStep) {
        System.out.println("Board is managing the final Position...");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Thread intrupped!!!");
        }

        Cell current = user.getToken().getCell();

        int currentIndex = this.getCellIndex(current);
        // step 1 : Check if the move is not going out of board. If so do nothing
        if(currentIndex + byStep > ( this.ROW * this.COLUMN - 1)) {
            System.out.println("Out of board..so doing nothing");
            return null;
        }

        int moveCellNum = currentIndex + byStep;
        Cell moveCell = this.getCell(moveCellNum);
        // System.out.println("(old, new) : (%d, %d)".formatted(currentIndex, moveCellNum) + ", move Cell : X : " + moveCell.getPosX() + " Y : " + moveCell.getPosY());
        // step 2 : check if the token reaching to last cell of the board. If so declared the user as Winner.
        if(isLastCell(moveCellNum)) {
            System.out.println("Winner from system: Token ID : " + user.getToken().getId());
            return user;
        }

        // ( clarification to be taken from interivew : What if a cell is ladder base also and snake head also than how to handle that case)
        // for now giving priority to ladder base ( final decision : where I and interview both get alligned )
        // Also there might be more than one ladder or snake on a target cell in that case which needs to be considered will be decided after having discussion with him

        // step 3: check if the final move postion has some snake or ladder
        if(isLadderBaseCell(moveCellNum)) {
            Ladder ladder = getLadderByBaseCell(moveCell);
            ladder.climb(user);
            return walkTheToken(user, 0); // what if the cell where the ladder ends a new ladder starts so making recurrsive call
        }

        // step 3: check if the final move postion has some snake or ladder
        if(isSnakeHeadCell(moveCellNum)) {
            Snake snake = this.getSnakeByHeadCell(moveCell);
            snake.bites(user);
            return walkTheToken(user, 0); // what if the cell where the ladder ends a new ladder starts so making recurrsive call
        }

        // Simply update the Cell for the user
        user.getToken().setCell(moveCell);
        return null;
    }
}
