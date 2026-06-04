package Patterns.Command;

public class Main {
    public static void main(String[] args) {
        RemonteControl remonteControl = new RemonteControl();

        // Appliances
        Light light = new Light();
        Fan fan = new Fan();
        
        // trun on the light
        remonteControl.setCommand(new LightOnCommand(light));
        remonteControl.pressButton();

        //trun off the ligh
        remonteControl.setCommand(new LightOffCommand(light));
        remonteControl.pressButton();

        //trun on the fan
        remonteControl.setCommand(new FanOnCommand(fan));
        remonteControl.pressButton();

        // trun off the fan
        remonteControl.setCommand(new FanOffCommand(fan));
        remonteControl.pressButton();
    }
}

class RemonteControl {
    private Command command;
    void setCommand(Command command) {
        this.command = command;
    }

    void pressButton() {
        if(command == null) {
            throw new RuntimeException("Command is not set.");
        }

        command.execute();
    }
}
