package Patterns.Command;

public class Fan implements OnOffAppliance {
    private boolean isOn = false;
    public void trunOn() {
        isOn = true;
        System.out.println("Fan is truned On");
    }

    public void trunOff() {
        isOn = false;
        System.out.println("Fan is truned OFF");
    }
}
