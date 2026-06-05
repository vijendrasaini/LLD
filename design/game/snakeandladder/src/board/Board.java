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
        cellNum--;
        if( cellNum < 0 || cellNum > this.ROW * this.COLUMN - 1) {
            throw new RuntimeException("Invalide Cell Number");
        }

        int[] pos = GameMath.getRowNCol(cellNum, this.COLUMN);
        return this.board.get(pos[0]).get(pos[1]);
    }

    public boolean isStartCell(Cell cell) {
        return cell.getPosX() == 0 && cell.getPosY() == 0;
    }

    public boolean isFinishCell(Cell cell) {
        return cell.getPosX() == this.ROW && cell.getPosY() == this.COLUMN;
    }

    public void walkTheToken(User user, int byStep) {
        System.out.println("Board is managing the final Position...");
    }
}
