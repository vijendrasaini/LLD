package Problems.ElevatorV1;

import java.util.ArrayList;
import java.util.List;

import Problems.ElevatorV1.Request.ExternalRequest;
import Problems.ElevatorV1.Strategy.AssignElevetorStrategy;
import Problems.ElevatorV1.Strategy.AssignElevator.AssignRequestedByElevator;
import Problems.ElevatorV1.Strategy.AssignElevator.SameDirectionAndNearByElevator;

public class Controller {
    private static final Controller INSTANCE = new Controller();
    private List<Lift> elevatorsList;
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

    public void registerElevetor(Lift elevetor) {
        elevatorsList.add(elevetor);
    }

    public void processExternalRequest(ExternalRequest request) {
        Lift elevetor = request.getElevetor();
        Floor floor = elevetor.getCurrentFloor();
        Direction direction = request.getDirection();

        Lift assignedElevetor = this.assignElevetorStrategy.getElevetor(elevetor, elevatorsList, direction);
        assignedElevetor.processDestinationFloor(request.getUserAtFloor());
    }

    public Lift getElevator(int id) {
        for (Lift lift : elevatorsList) {
            if(lift.getId() == id) return lift;
        }

        return null;
    }
}
