package Problems.ElevatorV1;

import java.util.ArrayList;
import java.util.List;

import Problems.ElevatorV1.Request.ExternalRequest;
import Problems.ElevatorV1.Strategy.AssignElevetorStrategy;
import Problems.ElevatorV1.Strategy.AssignElevator.AssignRequestedByElevator;
import Problems.ElevatorV1.Strategy.AssignElevator.SameDirectionAndNearByElevator;

public class Controller {
    private static final Controller INSTANCE = new Controller();
    private List<Elevator> elevatorsList;
    private AssignElevetorStrategy assignElevetorStrategy;

    private Controller() {
        elevatorsList = new ArrayList<>();
    };

    public static Controller getInstance() {
        return INSTANCE;
    }

    public AssignElevetorStrategy getAssignElevetorStrategy() {
        return assignElevetorStrategy;
    }

    public void setAssignElevetorStrategy(AssignElevetorStrategy assignElevetorStrategy) {
        if(assignElevetorStrategy instanceof AssignRequestedByElevator) {
            System.out.println(assignElevetorStrategy.getClass().getName() + " is configured");
        }

        this.assignElevetorStrategy = assignElevetorStrategy;
    }

    public void registerElevetor(Elevator elevetor) {
        elevatorsList.add(elevetor);
    }

    public void processExternalRequest(ExternalRequest request) {
        Elevator elevetor = request.getElevetor();
        Floor floor = elevetor.getCurrentFloor();
        Direction direction = request.getDirection();

        Elevator assignedElevetor = this.assignElevetorStrategy.getElevetor(elevetor, elevatorsList, direction);
        assignedElevetor.processDestinationFloor(request.getUserAtFloor());
    }

    public Elevator getElevator(int id) {
        for (Elevator lift : elevatorsList) {
            if(lift.getId() == id) return lift;
        }

        return null;
    }
}
