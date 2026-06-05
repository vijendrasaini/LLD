package design.game.snakeandladder.src.moveprovider;

public class Dice implements MoveProvider {
    public int get() {
        return (int) ( Math.random() * 6 ) + 1;
    }
}
