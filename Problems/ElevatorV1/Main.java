package Problems.ElevatorV1;

import Problems.ElevatorV1.Strategy.AssignElevatorStrategy;
import Problems.ElevatorV1.Strategy.AssignElevator.AssignRequestedByElevator;

public class Main {
    public static void main(String[] args) {
        Controller controller = Controller.getInstance();
        AssignElevatorStrategy assignElevatorStrategy = new AssignRequestedByElevator();
        controller.setAssignElevatorStrategy(assignElevatorStrategy);

        // let's test it for now for 2 lifts
        Elevator lift1 = new Elevator(); // id = 1;
        Elevator lift2 = new Elevator(); // id = 2;


        controller.registerElevator(lift1);
        controller.registerElevator(lift2);

        UI.userInputProcessor();
    }
}
