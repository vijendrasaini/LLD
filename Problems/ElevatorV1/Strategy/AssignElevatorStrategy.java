package Problems.ElevatorV1.Strategy;

import java.util.List;

import Problems.ElevatorV1.Direction;
import Problems.ElevatorV1.Elevator;

public interface AssignElevatorStrategy {
    Elevator getElevator(Elevator requestFromLift, List<Elevator> lifts, Direction direction);
}