package Patterns.Command;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RemonteControl remonteControl = new RemonteControl();

        // Appliances
        Light light = new Light();
        Fan fan = new Fan();
        
        // trun on the light
        remonteControl.setCommand(new LightCommand(light));
        remonteControl.pressButton();
        remonteControl.pressUndoButton();

        //trun on the fan
        remonteControl.setCommand(new FanCommand(fan));
        remonteControl.pressButton();
        remonteControl.pressUndoButton();
    }
}

class RemonteControl {
    private Command command;
    private Deque<Command> stack;
    public RemonteControl() {
        stack = new ArrayDeque<>();
    }

    void setCommand(Command command) {
        this.command = command;
    }

    void pressButton() {
        if(command == null) {
            throw new RuntimeException("Command is not set.");
        }

        command.execute();
        stack.push(command);
    }

    void pressUndoButton() {
        if(stack.isEmpty()) {
            return;
        }

        Command command = stack.poll();
        command.undo();
    }
}
