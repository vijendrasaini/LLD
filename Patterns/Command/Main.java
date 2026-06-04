package Patterns.Command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        RemoteControl remonteControl = new RemoteControl();
        
        // LightCommand lightCommand = new LightCommand(new Light());
        
        // Appliances
        remonteControl.pressKey(Key.FOR_LIGHT);
        remonteControl.pressKey(Key.FOR_FAN);
        remonteControl.showStatus();
        remonteControl.pressUndoButton();
        remonteControl.pressUndoButton();
        remonteControl.showStatus();
        remonteControl.pressKey(Key.FOR_LIGHT);
        remonteControl.pressKey(Key.FOR_FAN);
        remonteControl.showStatus();
        remonteControl.pressUndoButton();
        remonteControl.pressUndoButton();
        remonteControl.pressRedoButton();
        remonteControl.pressKey(Key.FOR_FAN);
    }
}

enum Key {
    FOR_LIGHT,
    FOR_FAN
}

class ApplianceCommand {
}

class RemoteControl {
    private Deque<Command> undoStack;
    private Deque<Command> redoStack;

    private static Map<Key, Command> keyCommandMap = new HashMap<>();
    public RemoteControl() {
        undoStack = new ArrayDeque<>();
        redoStack = new ArrayDeque<>();

        keyCommandMap.put(Key.FOR_LIGHT, new LightCommand(new Light()));
        keyCommandMap.put(Key.FOR_FAN, new FanCommand(new Fan()));
    }

    void showStatus() {
        System.out.println(undoStack);
        System.out.println(redoStack);
    }
    void pressKey(Key key) {
        Command command = keyCommandMap.get(key);
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    void pressUndoButton() {
        if(undoStack.isEmpty()) {
            System.out.println("Nothing to Undo");
            return;
        }

        Command command = undoStack.pop();
        redoStack.push(command);
        command.undo();
    }

    void pressRedoButton() {
        if(redoStack.isEmpty()) {
            System.out.println("Nothing to Redo");
            return;
        }

        Command command = redoStack.pop();
        command.execute();
        undoStack.push(command);
    }
}
