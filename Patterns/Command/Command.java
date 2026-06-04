package Patterns.Command;

public interface Command {
    void execute();
}


class LightOnCommand implements Command{
    private OnOffAppliance light;
    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.trunOn();
    }
}

class LightOffCommand implements Command{
    private OnOffAppliance light;
    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.trunOff();
    }
}

class FanOnCommand implements Command{
    private OnOffAppliance fan;
    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.trunOn();
    }
}

class FanOffCommand implements Command{
    private OnOffAppliance fan;
    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.trunOff();
    }
}