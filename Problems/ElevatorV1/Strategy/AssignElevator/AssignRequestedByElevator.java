package Problems.ElevatorV1.Strategy.AssignElevator;

import java.util.List;

import Problems.ElevatorV1.Direction;
import Problems.ElevatorV1.Lift;
import Problems.ElevatorV1.Strategy.AssignElevetorStrategy;

public class AssignRequestedByElevator implements AssignElevetorStrategy{
    @Override
    public Lift getElevetor(Lift requestFromLift, List<Lift> lifts, Direction direction) {
        return requestFromLift;
    }
}
