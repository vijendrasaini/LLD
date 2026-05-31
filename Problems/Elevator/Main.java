package Problems.Elevator;

import Problems.Elevator.Strategy.AssignElevetorStrategy;
import Problems.Elevator.Strategy.AssignElevator.AssignRequestedByElevator;

public class Main {
    public static void main(String[] args) {
        Controller controller = Controller.getInstance();
        AssignElevetorStrategy assignElevetorStrategy = new AssignRequestedByElevator();
        controller.setAssignElevetorStrategy(assignElevetorStrategy);

        // let's test it for now for 2 lifts
        Lift lift1 = new Lift(); // id = 1;
        Lift lift2 = new Lift(); // id = 2;


        controller.registerElevetor(lift1);
        controller.registerElevetor(lift2);

        UI.userInputProcessor();
    }
}
