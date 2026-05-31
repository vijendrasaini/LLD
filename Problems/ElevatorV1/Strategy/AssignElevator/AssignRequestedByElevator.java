package Problems.ElevatorV1.Strategy.AssignElevator;

import java.util.List;

import Problems.ElevatorV1.Direction;
import Problems.ElevatorV1.Elevator;
import Problems.ElevatorV1.Strategy.AssignElevatorStrategy;

public class AssignRequestedByElevator implements AssignElevatorStrategy{
    @Override
    public Elevator getElevator(Elevator requestFromLift, List<Elevator> lifts, Direction direction) {
        return requestFromLift;
    }
}
