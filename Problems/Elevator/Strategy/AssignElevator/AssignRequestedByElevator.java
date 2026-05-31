package Problems.Elevator.Strategy.AssignElevator;

import java.util.List;

import Problems.Elevator.Direction;
import Problems.Elevator.Lift;
import Problems.Elevator.Strategy.AssignElevetorStrategy;

public class AssignRequestedByElevator implements AssignElevetorStrategy{
    @Override
    public Lift getElevetor(Lift requestFromLift, List<Lift> lifts, Direction direction) {
        return requestFromLift;
    }
}
