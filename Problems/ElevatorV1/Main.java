package Problems.ElevatorV1;

import Problems.ElevatorV1.Strategy.AssignElevetorStrategy;
import Problems.ElevatorV1.Strategy.AssignElevator.AssignRequestedByElevator;

public class Main {
    public static void main(String[] args) {
        Controller controller = Controller.getInstance();
        AssignElevetorStrategy assignElevetorStrategy = new AssignRequestedByElevator();
        controller.setAssignElevetorStrategy(assignElevetorStrategy);

        // let's test it for now for 2 lifts
        Elevator lift1 = new Elevator(); // id = 1;
        Elevator lift2 = new Elevator(); // id = 2;


        controller.registerElevetor(lift1);
        controller.registerElevetor(lift2);

        UI.userInputProcessor();
    }
}
