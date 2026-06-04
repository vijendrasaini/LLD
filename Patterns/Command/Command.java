package Patterns.Command;

public interface Command {
    void execute();
    void undo();
}


class LightCommand implements Command {
    private OnOffAppliance light;
    public LightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.trunOn();
    }

    @Override
    public void undo() {
        light.trunOff();
    }
}

class FanCommand implements Command{
    private OnOffAppliance fan;
    public FanCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.trunOn();
    }

    @Override
    public void undo() {
        fan.trunOff();
    }
}