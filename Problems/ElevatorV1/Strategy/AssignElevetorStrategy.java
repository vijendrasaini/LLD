package Problems.ElevatorV1.Strategy;

import java.util.List;

import Problems.ElevatorV1.Direction;
import Problems.ElevatorV1.Lift;

public interface AssignElevetorStrategy {
    Lift getElevetor(Lift requestFromLift, List<Lift> lifts, Direction direction);
}