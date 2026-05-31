package Problems.Elevator.Strategy;

import java.util.List;

import Problems.Elevator.Direction;
import Problems.Elevator.Lift;

public interface AssignElevetorStrategy {
    Lift getElevetor(Lift requestFromLift, List<Lift> lifts, Direction direction);
}