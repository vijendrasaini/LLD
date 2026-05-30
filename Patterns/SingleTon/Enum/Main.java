package Patterns.SingleTon.Enum;

public class Main {
    public static void main(String[] args) {
        System.out.println(ConfigManager.INSTANCE == ConfigManager.INSTANCE);

        ConfigManager.INSTANCE.doSomething();
    }
}
