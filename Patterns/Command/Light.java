package Patterns.Command;

public class Light implements OnOffAppliance {
    private boolean isOn = false;
    public void trunOn() {
        isOn = true;
        System.out.println("LIGHT is truned On");
    }

    public void trunOff() {
        isOn = false;
        System.out.println("LIGHT is truned OFF");
    }
}