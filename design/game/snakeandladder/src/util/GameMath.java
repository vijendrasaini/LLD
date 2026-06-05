package design.game.snakeandladder.src.util;

public class GameMath {
    public static int[] getRowNCol(int n, int col) {
        return new int[]{n / col, n % col};
    }
}
