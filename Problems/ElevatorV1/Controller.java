package Problems.ElevatorV1;

import java.util.ArrayList;
import java.util.List;

import Problems.ElevatorV1.Request.ExternalRequest;
import Problems.ElevatorV1.Strategy.AssignElevatorStrategy;
import Problems.ElevatorV1.Strategy.AssignElevator.AssignRequestedByElevator;
import Problems.ElevatorV1.Strategy.AssignElevator.SameDirectionAndNearByElevator;

public class Controller {
    private static final Controller INSTANCE = new Controller();
    private List<Elevator> elevatorsList;
    private AssignElevatorStrategy assignElevatorStrategy;

    private Controller() {
        elevatorsList = new ArrayList<>();
    };

    public static Controller getInstance() {
        return INSTANCE;
    }

    public AssignElevatorStrategy getAssignElevatorStrategy() {
        return assignElevatorStrategy;
    }

    public void setAssignElevatorStrategy(AssignElevatorStrategy assignElevatorStrategy) {
        if(assignElevatorStrategy instanceof AssignRequestedByElevator) {
            System.out.println(assignElevatorStrategy.getClass().getName() + " is configured");
        }

        this.assignElevatorStrategy = assignElevatorStrategy;
    }

    public void registerElevator(Elevator elevetor) {
        elevatorsList.add(elevetor);
    }

    public void processExternalRequest(ExternalRequest request) {
        Elevator elevetor = request.getElevator();
        Floor floor = elevetor.getCurrentFloor();
        Direction direction = request.getDirection();

        Elevator assignedElevator = this.assignElevatorStrategy.getElevator(elevetor, elevatorsList, direction);
        assignedElevator.processDestinationFloor(request.getUserAtFloor());
    }

    public Elevator getElevator(int id) {
        for (Elevator lift : elevatorsList) {
            if(lift.getId() == id) return lift;
        }

        return null;
    }
}
