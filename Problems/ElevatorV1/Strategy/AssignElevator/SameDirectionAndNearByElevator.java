package Problems.ElevatorV1.Strategy.AssignElevator;

import java.util.ArrayList;
import java.util.List;

import Problems.ElevatorV1.Direction;
import Problems.ElevatorV1.ElevatorState;
import Problems.ElevatorV1.Floor;
import Problems.ElevatorV1.Elevator;
import Problems.ElevatorV1.Strategy.AssignElevatorStrategy;

public class SameDirectionAndNearByElevator implements AssignElevatorStrategy{
    public Elevator getElevator(Elevator requestFromLift, List<Elevator> lifts, Direction direction) {
        List<Elevator> goingInDirectionLifts = new ArrayList<>();
        List<Elevator> inRestLifts = new ArrayList<>();
        Floor currentFloor = requestFromLift.getCurrentFloor();

        for (Elevator lift : lifts) {
            if(lift.getElevatorState() == ElevatorState.IN_REST) {
                inRestLifts.add(lift);
                continue;
            }

            if(direction == Direction.UP && lift.getElevatorState() == ElevatorState.MOVEING_UP) {
                goingInDirectionLifts.add(lift);
            }
            
            if(direction == Direction.DOWN && lift.getElevatorState() == ElevatorState.MOVEING_DOWN) {
                goingInDirectionLifts.add(lift);
            }
        }

        List<Elevator> nearByLifts = new ArrayList<>();
        for (Elevator lift : goingInDirectionLifts) {
            if(direction == Direction.UP && currentFloor.ordinal() - lift.getCurrentFloor().ordinal() > 0) { // Potential nearby lift
                nearByLifts.add(lift);
            }

            if(direction == Direction.DOWN && lift.getCurrentFloor().ordinal() - currentFloor.ordinal() > 0) { // Potential nearby lift
                nearByLifts.add(lift);
            }
        }

        if(!nearByLifts.isEmpty()) {
            // sort the list to get near by and return one
            nearByLifts.sort((a, b) -> {
                int result = a.getCurrentFloor().ordinal() - b.getCurrentFloor().ordinal();
                if(direction == Direction.UP) return result;
                return - result;
            });

            return nearByLifts.getLast();
        } else {
            // No potential lift which is move in direction & could be assign in current round 
            // look for InRest and return any one ( However we should check the near by one by the differect with respect to current floor)
            // since some lifts could be above the requested floor or could down to that.
            // for simplicity , returning first from inrest lifts
            if(!inRestLifts.isEmpty()) return inRestLifts.getFirst();
        }

        // if still not found than we have to return lift which is moving in opposite direction and can come quickly
        // for simplicity , return first from the elevator list since logic will become complex
        return lifts.getFirst();
    }
    
}
