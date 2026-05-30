package Patterns.SingleTon.DoubleChecked;

public class DoubleChecked {
    private static DoubleChecked instance;
    private DoubleChecked() {}

    public static DoubleChecked getInstance() {
        if(instance == null) {
            synchronized(DoubleChecked.class) {
                if(instance == null) {
                    instance = new DoubleChecked();
                }
            }
        }

        return instance;
    }
}
