package Problems.ElevatorV1.Strategy.AssignElevator;

import java.util.List;

import Problems.ElevatorV1.Direction;
import Problems.ElevatorV1.Elevator;
import Problems.ElevatorV1.Strategy.AssignElevetorStrategy;

public class AssignRequestedByElevator implements AssignElevetorStrategy{
    @Override
    public Elevator getElevetor(Elevator requestFromLift, List<Elevator> lifts, Direction direction) {
        return requestFromLift;
    }
}
